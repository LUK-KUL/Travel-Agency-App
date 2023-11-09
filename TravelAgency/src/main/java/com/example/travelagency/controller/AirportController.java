package com.example.travelagency.controller;

import com.example.travelagency.model.AirportModel;
import com.example.travelagency.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AirportController {
    private final AirportService airportService;

    @GetMapping("/airports")
    public List<AirportModel> getAirports(){ return airportService.getAllAirports();}

    @PostMapping("/addAirport")
    public void addAirport(AirportModel airportModel) {airportService.addAirport(airportModel);}

    @PostMapping("/editAirport/{id}")
    public void editAirport(AirportModel airportModel) {airportService.saveEditedAirport(airportModel);}

    @PostMapping("/removeAirport/{id}")
    public void removeAirport(@PathVariable("id") Long id) { airportService.removeAirport(id);}

    @GetMapping("/getAirportById/{id}")
    public AirportModel getAirportById(@PathVariable("id") Long id) {return airportService.findAirportById(id);}

    @GetMapping("/getAirportByName/{name}")
    public List<AirportModel> getAirportByName(@PathVariable("name") String name) {return airportService.findAirportByName(name);}

    @GetMapping("/getAirportByName/{city}")
    public List<AirportModel> getAirportByCity(@PathVariable("city") String city) {return airportService.findAirportByCity(city);}

    @PostMapping("/updateAirportByName/{id}/{newName}")
    public void updateAirportByName(@PathVariable("id") Long id,@PathVariable("newName") String newName) { airportService.updateAirportByName(id, newName);}

    @PostMapping("/updateAirportByName/{id}/{cityId}")
    public void updateAirportByCity(@PathVariable("id") Long id,@PathVariable("cityId") Long cityId) { airportService.updateAirportByCity(id, cityId);}

}
