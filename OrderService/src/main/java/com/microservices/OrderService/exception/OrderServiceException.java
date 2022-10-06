package com.microservices.OrderService.exception;

public class OrderServiceException extends RuntimeException{

    public OrderServiceException(String message){
        super(message);
    }

}
