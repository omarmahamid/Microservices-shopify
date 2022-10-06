package com.microservices.OrderService.model;


import java.time.Instant;

public class OrderDTO{

    private long productId;
    private int quantity;
    private Instant orderDate;
    private String orderStatus;
    private double amount;

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

    public static OrderDTOBuilder builder(){
        return new OrderDTOBuilder();
    }

    public static class OrderDTOBuilder{

        private final OrderDTO orderDTO;

        public OrderDTOBuilder(){
            orderDTO = new OrderDTO();
        }

        public OrderDTOBuilder setProductId(long productId) {
            orderDTO.setProductId(productId);
            return this;
        }


        public OrderDTOBuilder setQuantity(int quantity) {
            orderDTO.setQuantity(quantity);
            return this;
        }


        public OrderDTOBuilder setOrderDate(Instant orderDate) {
            orderDTO.setOrderDate(orderDate);
            return this;
        }


        public OrderDTOBuilder setOrderStatus(String orderStatus) {
            orderDTO.setOrderStatus(orderStatus);
            return this;
        }

        public OrderDTOBuilder setAmount(double amount) {
            orderDTO.setAmount(amount);
            return this;
        }

        public OrderDTO getOrderDTO(){
            return orderDTO;
        }
    }
}
