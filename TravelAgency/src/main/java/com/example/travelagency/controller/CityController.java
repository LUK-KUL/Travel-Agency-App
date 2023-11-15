package com.example.travelagency.controller;

import com.example.travelagency.model.AirportModel;
import com.example.travelagency.model.CityModel;
import com.example.travelagency.service.AirportService;
import com.example.travelagency.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CityController {
    private final CityService cityService;

    @GetMapping("/getCities")
    public List<CityModel> get() {
        return cityService.getAllCities();
    }

    @PostMapping("/addCity")
    public void addCity(@RequestBody CityModel cityModel) {
        cityService.addCity(cityModel);
    }

    @PostMapping("/editCity/{id}")
    public void editCity(@RequestBody CityModel cityModel) {
        cityService.saveEditedCity(cityModel);
    }

    @PostMapping("/removeCity/{id}")
    public void removeCity(@PathVariable("id") Long id) {
        cityService.removeCity(id);
    }

    @GetMapping("/getCityById/{id}")
    public CityModel getCityById(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @GetMapping("/getCityByname/{name}")
    public CityModel getCityByName(@PathVariable("name") String name) {
        return cityService.findCityByName(name);
    }

    @GetMapping("/getCityByCountry/{countryId}")
    public List<CityModel> getCityByCountryId(@PathVariable("countryId") Long countryId) {
        return cityService.findCityByCountry(countryId);
    }

    @PostMapping("/updateCityByName/{id}/{cityName}")
    public void updateCityByName(@PathVariable("id") Long id, @PathVariable("cityName") String cityName) {
        cityService.updateCityByName(id, cityName);
    }

    @PostMapping("/updateCityByCountry/{id}/{countryId}")
    public void updateCityByCountry(@PathVariable("id") Long id, @PathVariable("countryId") Long countryId) {
        cityService.updateCityByCountry(id, countryId);
    }

}