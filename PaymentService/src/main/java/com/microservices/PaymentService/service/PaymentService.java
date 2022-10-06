package com.microservices.PaymentService.service;


import com.microservices.PaymentService.entity.PaymentDetails;
import com.microservices.PaymentService.model.PaymentRequest;
import com.microservices.PaymentService.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService{

    private final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);


    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void addPayment(PaymentRequest paymentRequest) {

        PaymentDetails paymentDetails = PaymentDetails.builder()
                .setOrderId(paymentRequest.getOrderId())
                .setAmount(paymentRequest.getAmount())
                .setReferenceNumber(paymentRequest.getReferenceNumber())
                .setPaymentMode(paymentRequest.getPaymentMode().name())
                .getPaymentDetails();

        LOGGER.info("going to save payment with id {}", paymentDetails.getPaymentId());
        paymentRepository.save(paymentDetails);
    }
}
