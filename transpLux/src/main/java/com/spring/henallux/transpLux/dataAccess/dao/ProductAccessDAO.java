package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.exceptions.EmptyProductListException;
import com.spring.henallux.transpLux.exceptions.ProductNotFound;
import com.spring.henallux.transpLux.model.Product;

import java.util.ArrayList;

public interface ProductAccessDAO {
    ArrayList<Product> findProductsByCategory(String category) throws EmptyProductListException;
    Product findProductById(Integer id) throws ProductNotFound;
}
