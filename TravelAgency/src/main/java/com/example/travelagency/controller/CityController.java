package com.example.travelagency.controller;

import com.example.travelagency.model.AirportModel;
import com.example.travelagency.model.CityModel;
import com.example.travelagency.service.AirportService;
import com.example.travelagency.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CityController {
    private final CityService cityService;

    @GetMapping("/getCities")
    public List<CityModel> get(){return cityService.getAllCities();}

}
