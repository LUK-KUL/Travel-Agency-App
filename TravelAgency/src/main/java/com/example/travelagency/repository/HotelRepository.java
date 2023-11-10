package com.example.travelagency.repository;

import com.example.travelagency.model.CityModel;
import com.example.travelagency.model.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelModel, Long> {
    @Query("SELECT h FROM HotelModel h WHERE h.cityId = :cityId")
    List<HotelModel> findHotelByCity(Long cityId);
}
