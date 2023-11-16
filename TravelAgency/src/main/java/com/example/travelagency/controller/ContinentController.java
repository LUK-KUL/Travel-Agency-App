package com.example.travelagency.controller;

import com.example.travelagency.model.ContinentModel;
import com.example.travelagency.service.ContinentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class ContinentController {
    private final ContinentService continentService;

    @GetMapping("/getContinents")
    public List<ContinentModel> getAllContinents() {
        return continentService.getAllContinent();
    }

    @PostMapping("/addContinent")
    public void addContinent(@RequestBody ContinentModel continentModel) {
        continentService.addContinent(continentModel);
    }

    @PostMapping("/editContinent")
    public void editContinent(@RequestBody ContinentModel continentModel) {
        continentService.saveEditedContinent(continentModel);
    }

    @PostMapping("/removeContinent/{id}")
    public void removeContinent(@PathVariable("id") Long id) {
        continentService.removeContinent(id);
    }

    @GetMapping("/getContinentById/{id}")
    public ContinentModel getContinentById(@PathVariable("id") Long id) {
        return continentService.findContinentById(id);
    }

    @GetMapping("/getContinentByName/{continentName}")
    public List<ContinentModel> getContinentByName(@PathVariable("continentName") String continentName) {
        return continentService.findContinentByName(continentName);
    }


}
