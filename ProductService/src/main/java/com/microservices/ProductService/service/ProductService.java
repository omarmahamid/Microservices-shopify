package com.microservices.ProductService.service;


import com.microservices.ProductService.entity.Product;
import com.microservices.ProductService.exception.ProductServiceException;
import com.microservices.ProductService.model.ProductDTO;
import com.microservices.ProductService.model.ProductRequest;
import com.microservices.ProductService.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    private final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);


    @Autowired
    ProductRepository repository;

    @Override
    public long addProduct(ProductRequest request) {
        LOGGER.info("adding product {}", request.getName());
        Product product = Product.builder()
                .setName(request.getName())
                .setPrice(request.getPrice())
                .setQuantity(request.getQuantity())
                .getProduct();

        repository.save(product);
        LOGGER.info("productId {} added successfully", product.getProductId());
        return product.getProductId();
    }

    @Override
    public ProductDTO getProductById(long id) {
        LOGGER.info("Fetching productId {} from the DB", id);
        Product product = repository.findById(id).orElseThrow(() -> new ProductServiceException("Product with given id not found", "PRODUCT_NOT_FOUND"));
        return getProductDTO(product);
    }

    @Override
    public void reduceQuantity(long productId, int quantity) {
        LOGGER.info("Reducing quantity for productId {}", productId);

        Product product = repository.findById(productId)
                .orElseThrow(
                        () -> new ProductServiceException("Product with given id not found", "PRODUCT_NOT_FOUND")
                );

        if (product.getQuantity() < quantity){
            throw new ProductServiceException("Product does not sufficeient quantity",
                    "INSUFFICIENT_QUANTITY");
        }

        product.setQuantity(product.getQuantity() - quantity);
        repository.save(product);
        LOGGER.info("productId {} reduced successfully", productId);
    }

    private ProductDTO getProductDTO(Product product){
        return ProductDTO.builder()
                .setProductId(product.getProductId())
                .setProductName(product.getProductName())
                .setQuantity(product.getQuantity())
                .setPrice(product.getPrice())
                .getProductDTO();

    }
}
