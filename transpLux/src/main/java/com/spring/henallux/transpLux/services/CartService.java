package com.spring.henallux.transpLux.services;

import com.spring.henallux.transpLux.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private ProductService productService;

    @Autowired
    public CartService(ProductService productService) {
        this.productService = productService;
    }

    public double getCartTotalPriceWithoutDiscounts(Cart cart) {
        return cart.getProducts().values().stream().mapToDouble(p -> p.getProduct().getPrice() * p.getQuantity()).sum();
    }

    public double getTotalDiscounts(Cart cart) {
        return cart.getProducts().values().stream().mapToDouble(p -> p.getProduct().getDiscountPrice() * p.getQuantity()).sum();
    }

    public double getTotalPriceWithDiscounts(Cart cart) {
        return cart.getProducts().values().stream().mapToDouble(p -> p.getProduct().getPriceWithDiscount() * p.getQuantity()).sum();
    }

}
