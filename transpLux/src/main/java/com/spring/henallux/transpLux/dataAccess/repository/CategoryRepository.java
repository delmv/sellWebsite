package com.spring.henallux.transpLux.dataAccess.repository;

import com.spring.henallux.transpLux.dataAccess.entity.CategoryEntity;
import com.spring.henallux.transpLux.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
}
