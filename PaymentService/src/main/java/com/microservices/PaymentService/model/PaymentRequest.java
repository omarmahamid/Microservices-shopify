package com.microservices.PaymentService.model;

public class PaymentRequest{

    private long orderId;
    private double amount;
    private String referenceNumber;
    private PaymentMode paymentMode;

    public PaymentRequest(){

    }

    public PaymentRequest(long orderId,
                          double amount,
                          String referenceNumber,
                          PaymentMode paymentMode){
        this.orderId = orderId;
        this.amount = amount;
        this.referenceNumber = referenceNumber;
        this.paymentMode = paymentMode;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
