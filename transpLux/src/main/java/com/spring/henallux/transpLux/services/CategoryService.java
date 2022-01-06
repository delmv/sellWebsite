package com.spring.henallux.transpLux.services;

import com.spring.henallux.transpLux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.transpLux.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public ArrayList<Category> findAllCategory() {
        return categoryDAO.findAllCategory();
    }

}
