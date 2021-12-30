package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.ProductEntity;
import com.spring.henallux.transpLux.model.Product;
import com.spring.henallux.transpLux.model.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private Mapper mapper = new DozerBeanMapper();

    public ProductEntity productModelToProductEntity(Product product) {
        return mapper.map(product, ProductEntity.class);
    }

    public Product productEntityToProductModel(ProductEntity productEntity) {
        return mapper.map(productEntity, Product.class);
    }

}