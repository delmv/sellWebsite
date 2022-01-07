package com.spring.henallux.transpLux.services;

import com.spring.henallux.transpLux.dataAccess.dao.ProductDAO;
import com.spring.henallux.transpLux.exceptions.EmptyProductListException;
import com.spring.henallux.transpLux.model.Cart;
import com.spring.henallux.transpLux.model.Product;
import com.spring.henallux.transpLux.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    public ArrayList<Product> findProductsByCategory(String category) throws Exception {
        try {
            ArrayList<Product> products = productDAO.findProductsByCategory(category);

            for (Product product : products) {
                calculateDiscount(product);
                calculatePriceWithDiscount(product);
            }

            return products;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Product> findAllProducts() throws Exception {
        try {
            ArrayList<Product> products = productDAO.findProductsByCategory(null);

            for (Product product : products) {
                calculateDiscount(product);
                calculatePriceWithDiscount(product);
            }

            return products;
        } catch (Exception e) {
            throw e;
        }
    }

    public Product findProductById(Integer id) throws Exception {
        try {
            Product product = productDAO.findProductById(id);
            calculateDiscount(product);
            calculatePriceWithDiscount(product);

            return product;
        } catch (Exception e) {
            throw e;
        }
    }

    public void calculateDiscount(Product product) {
        Date today = new Date();
        Promotion promotion = product.getPromotion();

        if(promotion != null &&
                promotion.getStartingDate().compareTo(today) <= 0 &&
                promotion.getEndingDate().compareTo(today) >= 0) {

            product.setDiscountPrice(product.getPrice() * ( (double)promotion.getPercentage() / 100));

        } else {
            product.setDiscountPrice(0.0);
        }
    }

    public void calculatePriceWithDiscount(Product product) {
        Date today = new Date();
        Promotion promotion = product.getPromotion();

        if(promotion != null &&
                promotion.getStartingDate().compareTo(today) <= 0 &&
                promotion.getEndingDate().compareTo(today) >= 0) {

            product.setPriceWithDiscount(product.getPrice() * (1 - (double)promotion.getPercentage()/100));
        } else {
            product.setPriceWithDiscount(product.getPrice());
        }
    }

}
