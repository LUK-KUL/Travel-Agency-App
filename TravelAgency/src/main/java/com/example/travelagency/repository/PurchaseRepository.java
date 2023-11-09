package com.example.travelagency.repository;

import com.example.travelagency.model.PurchaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseModel, Long> {

}
