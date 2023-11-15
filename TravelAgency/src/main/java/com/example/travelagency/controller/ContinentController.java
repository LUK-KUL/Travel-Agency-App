package com.example.travelagency.controller;

import com.example.travelagency.model.ContinentModel;
import com.example.travelagency.service.ContinentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class ContinentController {
    private final ContinentService continentService;

    @GetMapping("/getContinents")
    public List<ContinentModel> getAllContinents(){
       return continentService.getAllContinent();
    }
}
