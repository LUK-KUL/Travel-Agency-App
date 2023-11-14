package com.example.travelagency.controller;

import com.example.travelagency.model.CityModel;
import com.example.travelagency.model.CountryModel;
import com.example.travelagency.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/getCountries")
    public List<CountryModel> get() {
        return countryService.getAllCountries();
    }

}
