package com.microservices.OrderService.entity;


import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "ORDER_DETAILS")
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "ORDER_DATE")
    private Instant orderDate;

    @Column(name = "STATUS")
    private String orderStatus;

    @Column(name = "TOTAL_AMOUNT")
    private double amount;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static OrderBuilder builder(){
        return new OrderBuilder();
    }

    public static class OrderBuilder{

        private final Order order;

        public OrderBuilder(){
            order = new Order();
        }

        public OrderBuilder setProductId(long productId) {
            order.setProductId(productId);
            return this;
        }


        public OrderBuilder setQuantity(int quantity) {
            order.setQuantity(quantity);
            return this;
        }


        public OrderBuilder setOrderDate(Instant orderDate) {
            order.setOrderDate(orderDate);
            return this;
        }


        public OrderBuilder setOrderStatus(String orderStatus) {
            order.setOrderStatus(orderStatus);
            return this;
        }

        public OrderBuilder setAmount(double amount) {
            order.setAmount(amount);
            return this;
        }

        public Order getOrder() {
            return order;
        }
    }
}
