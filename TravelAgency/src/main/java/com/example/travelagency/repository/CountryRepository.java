package com.example.travelagency.repository;

import com.example.travelagency.enums.Continent;
import com.example.travelagency.enums.Country;
import com.example.travelagency.model.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface CountryRepository extends JpaRepository <CountryModel, Long> {

    @Query("SELECT country FROM CountryModel country WHERE country.countryName = :name")
    List<CountryModel> findCountryByName(@Param("name") String name);

    @Query("SELECT country FROM CountryModel country WHERE country.continent = :continent")
    List<CountryModel> findCountryByContinent(Continent continent);

    @Modifying
    @Transactional
    @Query("UPDATE CountryModel country SET country.countryName = :countryName WHERE country.id =:id")
    void updateCountryNameById(@Param("id") Long id, @Param("countryName") Country countryName);

    @Modifying
    @Transactional
    @Query("UPDATE CountryModel country SET country.continent.id = :continentId WHERE country.id =:id")
    void updateCountryContinentById(@Param("id") Long id, @Param("continentId") Long continentId);
}
