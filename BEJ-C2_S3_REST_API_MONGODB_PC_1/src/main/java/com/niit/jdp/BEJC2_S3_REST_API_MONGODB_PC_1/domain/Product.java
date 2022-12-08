/*
 * Author Name: Pratik Goud
 * Date: 24-11-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.domain;

public class Product {
    private int productId;
    private String productName;
    private String productDescription;

    public Product() {
    }

    public Product(int productId, String productName, String productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
