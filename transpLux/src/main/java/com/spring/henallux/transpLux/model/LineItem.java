package com.spring.henallux.transpLux.model;

public class LineItem {

    private int quantity;
    private double realPrice;
    private int productId;

    public LineItem(int quantity, double realPrice, int productId) {
        this.quantity = quantity;
        this.realPrice = realPrice;
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(double realPrice) {
        this.realPrice = realPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
