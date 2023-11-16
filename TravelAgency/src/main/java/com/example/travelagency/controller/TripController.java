package com.example.travelagency.controller;

import com.example.travelagency.model.TripModel;
import com.example.travelagency.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TripController {
    private final TripService tripService;

    @GetMapping("/getAllTrips")
    public List<TripModel> getAllTrips() {
        return tripService.getAllTrip();
    }

    @PostMapping("/addTrip")
    public void addTrip(@RequestBody TripModel tripModel) {
        tripService.addTrip(tripModel);
    }

    @PostMapping("/editTrip")
    public void editTrip(@RequestBody TripModel tripModel) {
        tripService.saveEditedTrip(tripModel);
    }

    @PostMapping("/removeTrip/{id}")
    public void removeTrip(@PathVariable("id") Long id) {
        tripService.removeTrip(id);
    }

    @GetMapping("/getTripById/{id}")
    public TripModel getTripById(@PathVariable("id") Long id) {
        return tripService.findTripById(id);
    }

    @PostMapping("/updateTripByChildsAvailablePlaces/{id}/{childQuantity}")
    public void updateTripByChildsAvailablePlaces (@PathVariable("id") Long id, @PathVariable("childQuantity") int childQuantity){
        tripService.updateTripChildPlaces(id, childQuantity);
    }

    @PostMapping("/updateTripByAdultsAvailablePlaces/{id}/{adultQuantity}")
    public void updateTripByAdultsAvailablePlaces (@PathVariable("id") Long id, @PathVariable("adultQuantity") int adultQuantity){
        tripService.updateTripAdultPlaces(id, adultQuantity);
    }
}
