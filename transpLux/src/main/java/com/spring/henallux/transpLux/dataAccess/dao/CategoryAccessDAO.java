package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.model.Category;

import java.util.ArrayList;

public interface CategoryAccessDAO {
    ArrayList<Category> findAllCategory();
}
