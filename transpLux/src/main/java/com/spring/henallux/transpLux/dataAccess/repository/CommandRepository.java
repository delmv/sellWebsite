package com.spring.henallux.transpLux.dataAccess.repository;

import com.spring.henallux.transpLux.dataAccess.entity.CommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<CommandEntity, String> {

    @Query("UPDATE CommandEntity set isPaid = true where id = ?1")
    public void validatePayment(int orderId);

}
