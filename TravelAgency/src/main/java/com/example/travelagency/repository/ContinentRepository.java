package com.example.travelagency.repository;

import com.example.travelagency.model.ContinentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContinentRepository extends JpaRepository <ContinentModel, Long> {

    @Query("SELECT conti FROM ContinentModel conti WHERE conti.continentName = :continentName")
    List<ContinentModel> findContinentByName(@Param("continentName") String continentName);
}
