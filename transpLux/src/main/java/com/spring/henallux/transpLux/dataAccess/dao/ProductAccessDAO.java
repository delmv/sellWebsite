package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.exceptions.EmptyProductListException;
import com.spring.henallux.transpLux.model.Product;

import java.util.ArrayList;

public interface ProductAccessDAO {
    ArrayList<Product> findProductByCategory(String category) throws EmptyProductListException;
    ArrayList<Product> findAllProducts() throws EmptyProductListException;
}
