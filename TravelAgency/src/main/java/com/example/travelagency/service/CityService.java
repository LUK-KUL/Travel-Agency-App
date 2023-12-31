package com.example.travelagency.service;

import com.example.travelagency.model.AirportModel;
import com.example.travelagency.model.CityModel;
import com.example.travelagency.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public void addCity(CityModel cityModel) {
        cityRepository.save(cityModel);
    }

    public void saveEditedCity(CityModel editedCity) {
        cityRepository.save(editedCity);
    }

    public void removeCity(Long id) {
        cityRepository.deleteById(id);
    }

    public List<CityModel> getAllCities() {
        return cityRepository.findAll().stream().toList();
    }

    public CityModel findCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public CityModel findCityByName(String cityName) {
        return cityRepository.findCityByName(cityName);
    }

    public List<CityModel> findCityByCountry(Long countryId) {
        return cityRepository.findCityByCountry(countryId);
    }

    public void updateCityByName(Long id, String cityName) {
        cityRepository.updateCityNameById(id, cityName);
    }

    public void updateCityByCountry(Long id, Long countryId) {
        cityRepository.updateCityCountryById(id, countryId);
    }
}
