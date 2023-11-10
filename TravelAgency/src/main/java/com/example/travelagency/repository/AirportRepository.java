package com.example.travelagency.repository;

import com.example.travelagency.model.AirportModel;
import com.example.travelagency.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<AirportModel, Long> {
    @Query("SELECT a FROM AirportModel a WHERE a.airportName = :name")
    List<AirportModel> findAirportsByName(@Param("name") String name);

    @Query("SELECT a FROM AirportModel a WHERE a.cityId = :cityId")
    List<AirportModel> findAirportsByCity(@Param("cityId") Long cityId);

    @Modifying
    @Transactional
    @Query("UPDATE AirportModel a SET a.airportName = :airportName WHERE a.id =:id")
    int updateAirportNameById(@Param("id") Long id, @Param("airportName") String airportName);

    @Modifying
    @Transactional
    @Query("UPDATE AirportModel a SET a.cityId = :cityId WHERE a.id = :id")
    int updateAirportCityById(@Param("id") Long id, @Param("cityId") Long cityId);

}
