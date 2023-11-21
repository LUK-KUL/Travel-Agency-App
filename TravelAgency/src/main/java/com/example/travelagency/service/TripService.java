package com.example.travelagency.service;

import com.example.travelagency.model.TripModel;
import com.example.travelagency.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;

    public void addTrip(TripModel tripModel) {
        tripRepository.save(tripModel);
    }

    public void saveEditedTrip(TripModel editedTrip) {
        tripRepository.save(editedTrip);
    }

    public void removeTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public List<TripModel> getAllTrip() {
        return tripRepository.findAll().stream().toList();
    }

    public TripModel findTripById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public void updateTripChildPlaces(Long id, int childQuantity) {
        TripModel trip = findTripById(id);
        if (trip != null) {
            tripRepository.updateTripByChildPlaces(id,(trip.getChildPlaces() - childQuantity));
        }
    }

    public void updateTripAdultPlaces(Long id, int adultQuantity) {
        TripModel trip = findTripById(id);
        if (trip != null) {
            tripRepository.updateTripByAdultPlaces(id,(trip.getAdultPlaces() - adultQuantity));
        }
    }

    public void updateAvailability(TripModel tripModel) {
        tripModel.updateAvailability();
        saveEditedTrip(tripModel);
    }
}
