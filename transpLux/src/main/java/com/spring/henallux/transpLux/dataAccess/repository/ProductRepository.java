package com.spring.henallux.transpLux.dataAccess.repository;

import com.spring.henallux.transpLux.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    @Query("select product from ProductEntity product where product.category.defaultName like ?1")
    public List<ProductEntity> findProductEntityByCategory(String category);
}