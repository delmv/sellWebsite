package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.dataAccess.entity.ProductEntity;
import com.spring.henallux.transpLux.dataAccess.repository.ProductRepository;
import com.spring.henallux.transpLux.dataAccess.util.ProductConverter;
import com.spring.henallux.transpLux.exceptions.EmptyProductListException;
import com.spring.henallux.transpLux.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public ArrayList<Product> findProductsByCategory(String category) throws EmptyProductListException {
        List<ProductEntity> productEntities = null;
        if(category == null)
            productEntities = productRepository.findAll();
        else
            productEntities = productRepository.findProductEntityByCategory(category);


        if(productEntities.isEmpty())
            throw new EmptyProductListException();

        return (ArrayList<Product>) productEntities
                .stream()
                .map(productEntity -> productConverter.productEntityToProductModel(productEntity))
                .collect(Collectors.toList());

    }

    @Override
    public Product findProductById(Integer id) throws Exception {

        ProductEntity productEntity =  productRepository.findProductEntityById(id);

        if (productEntity == null) throw new Exception();

        return productConverter.productEntityToProductModel(productEntity);

    }

}