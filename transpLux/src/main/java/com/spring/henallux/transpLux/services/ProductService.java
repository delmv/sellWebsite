package com.spring.henallux.transpLux.services;

import com.spring.henallux.transpLux.dataAccess.dao.ProductDAO;
import com.spring.henallux.transpLux.exceptions.EmptyProductListException;
import com.spring.henallux.transpLux.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    public ArrayList<Product> findProductsByCategory(String category) throws Exception {
        try {
             return productDAO.findProductsByCategory(category);
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Product> findAllProducts() throws Exception {
        try {
            return productDAO.findProductsByCategory(null);
        } catch (Exception e) {
            throw e;
        }
    }

    public Product findProductById(Integer id) throws Exception {
        try {
            return productDAO.findProductById(id);
        } catch (Exception e) {
            throw e;
        }
    }

}
