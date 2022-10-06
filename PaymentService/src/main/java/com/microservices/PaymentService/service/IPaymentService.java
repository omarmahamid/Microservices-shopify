package com.microservices.PaymentService.service;

import com.microservices.PaymentService.model.PaymentRequest;

public interface IPaymentService{


    void addPayment(PaymentRequest paymentRequest);
}
