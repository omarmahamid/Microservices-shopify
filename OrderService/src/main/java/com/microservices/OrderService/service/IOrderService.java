package com.microservices.OrderService.service;

import com.microservices.OrderService.model.OrderDTO;
import com.microservices.OrderService.model.OrderRequest;

public interface IOrderService{

    long addOrder(OrderRequest request);

    OrderDTO getOrderById(long id);

}
