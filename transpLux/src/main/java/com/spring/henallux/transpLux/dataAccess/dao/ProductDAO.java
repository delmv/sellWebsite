package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.dataAccess.entity.ProductEntity;
import com.spring.henallux.transpLux.dataAccess.entity.UserEntity;
import com.spring.henallux.transpLux.dataAccess.repository.ProductRepository;
import com.spring.henallux.transpLux.dataAccess.repository.UserRepository;
import com.spring.henallux.transpLux.dataAccess.util.ProductConverter;
import com.spring.henallux.transpLux.dataAccess.util.UserConverter;
import com.spring.henallux.transpLux.exceptions.EmptyProductListException;
import com.spring.henallux.transpLux.model.Product;
import com.spring.henallux.transpLux.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDAO implements ProductAccessDAO {

    private ProductRepository productRepository;
    private ProductConverter productConverter;

    @Autowired
    public ProductDAO(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }


    @Override
    public ArrayList<Product> findProductByCategory(String category) throws EmptyProductListException {
        List<ProductEntity> productEntities = null;
        if(category == null)
            productEntities = productRepository.findAll();
        else
            productEntities = productRepository.findProductEntityByCategory(category);


        if(productEntities.isEmpty())
            throw new EmptyProductListException();

        ArrayList<Product> products = new ArrayList<>();
        for (ProductEntity productEntity: productEntities) {
            products.add(productConverter.productEntityToProductModel(productEntity));
        }

        return products;
    }

    public ArrayList<Product> findAllProducts() throws EmptyProductListException {
        return findProductByCategory(null);
    }
}