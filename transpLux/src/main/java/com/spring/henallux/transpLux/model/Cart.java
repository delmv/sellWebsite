package com.spring.henallux.transpLux.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart {

    private HashMap<Integer, CartItem> products;

    public Cart() {
        products = new HashMap<Integer, CartItem>();
    }

    public void addProduct(Product product, int quantity) {

        if (products.containsKey(product.getId())) {
            products.get(product.getId()).addQty(quantity);
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            products.put(product.getId(), cartItem);
        }

    }

    public HashMap<Integer, CartItem> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Integer, CartItem> products) {
        this.products = products;
    }

    public double getTotalPrice() {

        return products.values().stream().mapToDouble(p -> p.getProduct().getPrice() * p.getQuantity()).sum();

    }

    public double getTotalPriceWithoutDiscounts() {

        return products.values().stream().mapToDouble(p -> p.getProduct().getCurrentPrice() * p.getQuantity()).sum();

    }

    public double getTotalDiscounts() {

        return products.values().stream().mapToDouble(p -> p.getProduct().getDiscount() * p.getQuantity()).sum();

    }

    public Boolean isEmpty() {
        return products.isEmpty();
    }

}
