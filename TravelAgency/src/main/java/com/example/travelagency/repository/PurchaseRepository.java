package com.example.travelagency.repository;

import com.example.travelagency.model.PurchaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseModel, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE PurchaseModel p SET p.totalCost = :totalCost WHERE p.id =:id")
    void setTotalCost(@Param("id") Long id, @Param("totalCost") BigDecimal totalCost);

}
