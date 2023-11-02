package com.example.travelagency.repository;

import com.example.travelagency.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityModel, Long> {
    @Query("SELECT c FROM CityModel c WHERE c.cityName = :name")
    List<CityModel> findCityByName(@Param("name") String name);

    @Query("SELECT c FROM CityModel c WHERE c.country = :country")
    List<CityModel> findCityByCountry(String country);

    @Modifying
    @Transactional
    @Query("UPDATE CityModel c SET c.cityName = :cityName WHERE c.id =:id")
    void updateCityNameById(@Param("id") Long id, @Param("cityName") String name);

    @Modifying
    @Transactional
    @Query("UPDATE CityModel c SET c.country.id = :countryId WHERE c.id =:id")
    void updateCityCountryById(@Param("id") Long id, @Param("countryId") Long countryId);
}
