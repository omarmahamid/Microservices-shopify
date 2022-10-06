package com.microservices.PaymentService.controller;


import com.microservices.PaymentService.model.PaymentRequest;
import com.microservices.PaymentService.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController{

    @Autowired
    private IPaymentService paymentService;


    @PostMapping
    public ResponseEntity<Void> doPayment(@RequestBody PaymentRequest paymentRequest){
        paymentService.addPayment(paymentRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
