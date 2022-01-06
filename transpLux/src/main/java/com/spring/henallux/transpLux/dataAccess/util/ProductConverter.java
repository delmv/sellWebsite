package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.CategoryEntity;
import com.spring.henallux.transpLux.dataAccess.entity.ProductEntity;
import com.spring.henallux.transpLux.dataAccess.entity.TranslationEntity;
import com.spring.henallux.transpLux.model.Category;
import com.spring.henallux.transpLux.model.Product;
import com.spring.henallux.transpLux.model.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private CategoryConverter categoryConverter;

    @Autowired
    public ProductConverter(CategoryConverter categoryConverter) {
        this.categoryConverter = categoryConverter;
    }

    private Mapper mapper = new DozerBeanMapper();

    public ProductEntity productModelToProductEntity(Product product) {
        return mapper.map(product, ProductEntity.class);
    }

    public Product productEntityToProductModel(ProductEntity productEntity) {
        CategoryEntity categoryEntity = productEntity.getCategory();
        productEntity.setCategory(null);

        Product product = mapper.map(productEntity, Product.class);
        product.setCategory(categoryConverter.categoryEntityToCategoryModel(categoryEntity));

        return product;
    }

}