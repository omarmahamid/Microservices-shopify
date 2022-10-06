package com.microservices.OrderService.service;

import com.microservices.OrderService.entity.Order;
import com.microservices.OrderService.exception.OrderServiceException;
import com.microservices.OrderService.external.client.PaymentService;
import com.microservices.OrderService.external.client.ProductService;
import com.microservices.OrderService.external.request.PaymentRequest;
import com.microservices.OrderService.model.OrderDTO;
import com.microservices.OrderService.model.OrderRequest;
import com.microservices.OrderService.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class OrderService implements IOrderService{

    private final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentService paymentService;

    @Override
    public long addOrder(OrderRequest request) {

        Order order = Order.builder()
                .setProductId(request.getProductId())
                .setOrderDate(Instant.now())
                .setAmount(request.getTotalAmount())
                .setQuantity(request.getQuantity())
                .setOrderStatus("CREATED")
                .getOrder();

        LOGGER.info("Going to reduce {} quantity for productId {}", request.getQuantity() ,request.getProductId());
        productService.reduceQuantity(request.getProductId(), request.getQuantity());

        PaymentRequest paymentRequest = createPaymentRequest(request, order);

        LOGGER.info("going to pay for orderId {} for productId {}", order.getId(), request.getProductId());
        paymentService.doPayment(paymentRequest);


        LOGGER.info("Adding new orderId {} for productId: {}", order.getId(), order.getProductId());
        repository.save(order);
        LOGGER.info("OrderId {} Added successfully", order.getId());
        return order.getId();
    }

    private PaymentRequest createPaymentRequest(OrderRequest request, Order order) {

        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(order.getAmount());
        paymentRequest.setOrderId(order.getId());
        paymentRequest.setPaymentMode(request.getPaymentMode());
        return paymentRequest;
    }

    @Override
    public OrderDTO getOrderById(long id) {

        LOGGER.info("Fetching orderId {} from the DB", id);
        Order order = repository.findById(id).orElseThrow(
                () -> new OrderServiceException("Order with this id can't be found")
        );

        return createOrderDTO(order);
    }

    private OrderDTO createOrderDTO(Order order){
        return OrderDTO.builder()
                .setProductId(order.getProductId())
                .setAmount(order.getAmount())
                .setOrderDate(order.getOrderDate())
                .setQuantity(order.getQuantity())
                .setOrderStatus(order.getOrderStatus())
                .getOrderDTO();
    }
}
