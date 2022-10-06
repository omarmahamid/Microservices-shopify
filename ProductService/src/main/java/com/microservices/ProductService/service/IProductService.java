package com.microservices.ProductService.service;

import com.microservices.ProductService.model.ProductDTO;
import com.microservices.ProductService.model.ProductRequest;

public interface IProductService{


    long addProduct(ProductRequest request);

    ProductDTO getProductById(long id);

    void reduceQuantity(long productId, int quantity);
}
