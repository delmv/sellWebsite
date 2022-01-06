package com.spring.henallux.transpLux.dataAccess.repository;

import com.spring.henallux.transpLux.dataAccess.entity.LineItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends JpaRepository<LineItemEntity, String> {

}
