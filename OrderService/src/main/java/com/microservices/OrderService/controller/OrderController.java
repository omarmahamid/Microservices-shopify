package com.microservices.OrderService.controller;


import com.microservices.OrderService.model.OrderDTO;
import com.microservices.OrderService.model.OrderRequest;
import com.microservices.OrderService.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController{

    @Autowired
    private IOrderService orderService;

    @PostMapping
    public ResponseEntity<Long> addOrder(@RequestBody OrderRequest request){
        long id = orderService.addOrder(request);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable("orderId") long orderId){
        OrderDTO dto = orderService.getOrderById(orderId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
