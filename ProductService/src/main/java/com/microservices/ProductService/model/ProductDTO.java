package com.microservices.ProductService.model;

public class ProductDTO{

    private String productName;
    private long productId;
    private double price;
    private int quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static ProductDTOBuilder builder(){
        return new ProductDTOBuilder();
    }

    public static class ProductDTOBuilder{

        private final ProductDTO productDTO;

        public ProductDTOBuilder(){
            productDTO = new ProductDTO();
        }

        public ProductDTOBuilder setProductName(String productName) {
            productDTO.setProductName(productName);
            return this;
        }

        public ProductDTOBuilder setProductId(long productId) {
            productDTO.setProductId(productId);
            return this;
        }

        public ProductDTOBuilder setPrice(double price) {
            productDTO.setPrice(price);
            return this;
        }

        public ProductDTOBuilder setQuantity(int quantity) {
            productDTO.setQuantity(quantity);
            return this;
        }

        public ProductDTO getProductDTO() {
            return productDTO;
        }
    }
}
