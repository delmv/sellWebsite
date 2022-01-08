package com.spring.henallux.transpLux.services;

import com.spring.henallux.transpLux.model.Product;
import com.spring.henallux.transpLux.model.Promotion;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;
    private Product product;

    @BeforeEach
    public void setUp() {
        this.productService = new ProductService();

        Product product = new Product();
        Promotion promotion = new Promotion();


        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);

        promotion.setPercentage(20);
        promotion.setStartingDate(new Date());
        promotion.setEndingDate(c.getTime());

        product.setPromotion(promotion);
        product.setPrice(100.0);

        this.product = product;
    }

    @Test
    public void calculateDiscount() {
        productService.calculateDiscount(product);
        Assert.assertEquals(20.0, product.getDiscountPrice(), 1.0);
    }

    @Test
    public void calculatePriceWithDiscount() {
        productService.calculatePriceWithDiscount(product);
        Assert.assertEquals(80.0, product.getPriceWithDiscount(), 1.0);
    }

    @Test
    public void calculateDiscountWithoutPromotion() throws Exception {
        product.setPromotion(null);
        productService.calculateDiscount(product);
        Assert.assertEquals(0.0, product.getDiscountPrice(), 1.0);
    }

    @Test
    public void calculateDiscountWithExpiredPromotion() throws Exception {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);

        product.getPromotion().setEndingDate(c.getTime());

        c.add(Calendar.YEAR, -1);
        product.getPromotion().setStartingDate(c.getTime());

        productService.calculateDiscount(product);
        Assert.assertEquals(0.0, product.getDiscountPrice(), 1.0);
    }
}