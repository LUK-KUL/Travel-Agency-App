package com.example.travelagency.controller;

import com.example.travelagency.model.HotelModel;
import com.example.travelagency.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("/getAllHotels")
    public List<HotelModel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping("/addHotel")
    public void addHotel(@RequestBody HotelModel hotelModel){
        hotelService.addHotel(hotelModel);
    }

    @PostMapping("/editHotel")
    public void editHotel(@RequestBody HotelModel hotelModel){
        hotelService.saveEditedHotel(hotelModel);
    }
    @PostMapping("/removeHotel/{id}")
    public void removeHotel(@PathVariable("id") Long id){
        hotelService.removeHotel(id);
    }

    @GetMapping("/getHotelById/{id}")
    public HotelModel getHotelById (@PathVariable("id") Long id){
        return hotelService.findHotelById(id);
    }

    @GetMapping("/getHotelByCityId/{cityId}")
    public List<HotelModel> getHotelByCityId (@PathVariable("cityId") Long cityId){
        return hotelService.findHotelByCity(cityId);
    }
}
