package com.example.travelagency.controller;

import com.example.travelagency.model.CountryModel;
import com.example.travelagency.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/getCountries")
    public List<CountryModel> get() {
        return countryService.getAllCountries();
    }

    @PostMapping("/addCountry")
    public void addCountry(@RequestBody CountryModel countryModel) {
        countryService.addCountry(countryModel);
    }

    @PostMapping("/editCountry/{id}")
    public void editCountry(@RequestBody CountryModel countryModel) {
        countryService.saveEditedCountry(countryModel);
    }

    @PostMapping("/removeCountry/{id}")
    public void removeCountry(@PathVariable("id") Long id) {
        countryService.removeCountry(id);
    }

    @GetMapping("/getCountryById/{id}")
    public CountryModel getCountryById(@PathVariable("id") Long id) {
        return countryService.findCountryById(id);
    }

    @GetMapping("/getCountryByName/{name}")
    public List<CountryModel> getCountryByName(@PathVariable("name") String countryName) {
        return countryService.findCountryByName(countryName);
    }

    @GetMapping("/getCountryByContinent/{continentId}")
    public List<CountryModel> getCountryByContinent(@PathVariable("continentId") Long id) {
        return countryService.findCountryByContinent(id);
    }

    @PostMapping("/updateCountryByName/{id}/{name}")
    public void updateCountryByName(@PathVariable("id") Long id, @PathVariable("name") String countryName) {
        countryService.updateCountryByName(id, countryName);
    }

    @PostMapping("/updateCountryByContinent/{Id}/{continentId}")
    public void updateCountryByContinentId(@PathVariable("Id") Long id, @PathVariable("continentId") Long continentId) {
        countryService.updateCountryByContinent(id, continentId);
    }

}
