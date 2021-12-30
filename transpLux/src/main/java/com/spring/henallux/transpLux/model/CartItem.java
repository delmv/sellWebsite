package com.spring.henallux.transpLux.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CartItem {
    private Product product;

    @NotNull
    @Min(value = 1)
    private int quantity;

    public CartItem() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void addOne() {
        this.quantity += 1;
    }

    public void addQty(int nb) {
        this.quantity = nb;
    }
}
