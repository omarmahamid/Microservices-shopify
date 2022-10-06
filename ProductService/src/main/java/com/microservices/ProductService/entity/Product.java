package com.microservices.ProductService.entity;


import javax.persistence.*;

@Entity
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "QUANTITY")
    private int quantity;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public static ProductBuilder builder(){
        return new ProductBuilder();
    }

    public static class ProductBuilder{

        private final Product product;

        public ProductBuilder(){
            product = new Product();
        }

        public ProductBuilder setPrice(double price){
            product.setPrice(price);
            return this;
        }

        public ProductBuilder setQuantity(int quantity){
            product.setQuantity(quantity);
            return this;
        }

        public ProductBuilder setName(String name){
            product.setProductName(name);
            return this;
        }

        public Product getProduct(){
            return this.product;
        }
    }
}
