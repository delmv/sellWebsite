package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.dataAccess.entity.CategoryEntity;
import com.spring.henallux.transpLux.dataAccess.entity.ProductEntity;
import com.spring.henallux.transpLux.dataAccess.repository.CategoryRepository;
import com.spring.henallux.transpLux.dataAccess.util.CategoryConverter;
import com.spring.henallux.transpLux.exceptions.EmptyProductListException;
import com.spring.henallux.transpLux.model.Category;
import com.spring.henallux.transpLux.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryDAO implements CategoryAccessDAO{

    private CategoryRepository categoryRepository;
    private CategoryConverter categoryConverter;

    @Autowired
    public CategoryDAO(CategoryRepository categoryRepository, CategoryConverter categoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryConverter = categoryConverter;
    }

    @Override
    public ArrayList<Category> findAllCategory() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return (ArrayList<Category>) categoryEntities
                .stream()
                .map(categoryEntity -> categoryConverter.categoryEntityToCategoryModel(categoryEntity))
                .collect(Collectors.toList());
    }
}
