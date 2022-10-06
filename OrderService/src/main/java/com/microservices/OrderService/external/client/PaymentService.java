package com.microservices.OrderService.external.client;


import com.microservices.OrderService.external.request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE/payment")
public interface PaymentService{

    @PostMapping
    public ResponseEntity<Void> doPayment(@RequestBody PaymentRequest paymentRequest);

}
