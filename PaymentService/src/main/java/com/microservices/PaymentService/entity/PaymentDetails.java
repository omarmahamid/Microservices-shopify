package com.microservices.PaymentService.entity;


import javax.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "PAYMENT_DETAILS")
public class PaymentDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentId;

    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(name = "PAYMENT_MODE")
    private String paymentMode;

    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;

    @Column(name = "PAYMENT_DATE")
    private Instant paymentDate;

    @Column(name = "STATUS")
    private String paymentStatus;

    @Column(name = "AMOUNT")
    private double amount;

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static PaymentDetailsBuilder builder(){
        return new PaymentDetailsBuilder();
    }

    public static class PaymentDetailsBuilder{

        private final PaymentDetails paymentDetails;

        public PaymentDetailsBuilder(){
            paymentDetails = new PaymentDetails();
        }

        public PaymentDetailsBuilder setOrderId(long orderId) {
            paymentDetails.setOrderId(orderId);
            return this;
        }


        public PaymentDetailsBuilder setPaymentMode(String paymentMode) {
            paymentDetails.setPaymentMode(paymentMode);
            return this;
        }

        public PaymentDetailsBuilder setReferenceNumber(String referenceNumber) {
            paymentDetails.setReferenceNumber(referenceNumber);
            return this;
        }

        public PaymentDetailsBuilder setPaymentDate(Instant paymentDate) {
            paymentDetails.setPaymentDate(paymentDate);
            return this;
        }

        public PaymentDetailsBuilder setPaymentStatus(String paymentStatus) {
            paymentDetails.setPaymentStatus(paymentStatus);
            return this;
        }

        public PaymentDetailsBuilder setAmount(double amount) {
            paymentDetails.setAmount(amount);
            return this;
        }

        public PaymentDetails getPaymentDetails() {
            return paymentDetails;
        }
    }
}
