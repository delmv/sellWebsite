package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.CategoryEntity;
import com.spring.henallux.transpLux.model.Category;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    private Mapper mapper = new DozerBeanMapper();

    public CategoryEntity categoryModelToCategoryEntity(Category category) {
        return mapper.map(category, CategoryEntity.class);
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        return mapper.map(categoryEntity, Category.class);
    }

}
