package com.example.travelagency.controller;

import com.example.travelagency.model.AirportModel;
import com.example.travelagency.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AirportController {
    private final AirportService airportService;

    @GetMapping("/getAirports")
    public List<AirportModel> get(){return airportService.getAllAirports();}

    @PostMapping("/addAirport")
    public void addAirport(@RequestBody AirportModel airportModel) {airportService.addAirport(airportModel);}

    @PostMapping("/editAirport/{id}")
    public void editAirport(@RequestBody AirportModel airportModel) {airportService.saveEditedAirport(airportModel);}

    @PostMapping("/removeAirport/{id}")
    public void removeAirport(@PathVariable("id") Long id) { airportService.removeAirport(id);}

    @GetMapping("/getAirportById/{id}")
    public AirportModel getAirportById(@PathVariable("id") Long id) {return airportService.findAirportById(id);}

    @GetMapping("/getAirportByName/{name}")
    public List<AirportModel> getAirportByName(@PathVariable("name") String name) {return airportService.findAirportByName(name);}

    @GetMapping("/getAirportByCity/{cityId}")
    public List<AirportModel> getAirportByCity(@PathVariable("cityId") Long cityId) {return airportService.findAirportByCity(cityId);}

    @PostMapping("/updateAirportByName/{id}/{newName}")
    public void updateAirportByName(@PathVariable("id") Long id,@PathVariable("newName") String newName) { airportService.updateAirportByName(id, newName);}

    @PostMapping("/updateAirportByCity/{id}/{cityId}")
    public void updateAirportByCity(@PathVariable("id") Long id, @RequestParam("cityId") Long cityId) { airportService.updateAirportByCity(id, cityId);}

}
