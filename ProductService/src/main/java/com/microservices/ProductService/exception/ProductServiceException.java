package com.microservices.ProductService.exception;

public class ProductServiceException extends RuntimeException{

    private final String errorCode;

    public ProductServiceException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
