package com.example.travelagency.service;

import com.example.travelagency.model.AirportModel;
import com.example.travelagency.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public void addAirport(AirportModel airportModel) {
        airportRepository.save(airportModel);
    }

    public void saveEditedAirport(AirportModel editedAirport) {
        airportRepository.save(editedAirport);
    }

    public void removeAirport(Long id) {
        airportRepository.deleteById(id);
    }

    public List<AirportModel> getAllAirports() {
        return airportRepository.findAll().stream().toList();
    }

    public AirportModel findAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    public List<AirportModel> findAirportByName(String name) {
        return airportRepository.findAirportsByName(name);
    }

    public List<AirportModel> findAirportByCity(String city) {
        return airportRepository.findAirportsByCity(city);
    }

    public void updateAirportByName(Long id, String name) {
        airportRepository.updateAirportNameById(id, name);
    }

    public void updateAirportByCity(Long id, Long cityId) {
        airportRepository.updateAirportCityById(id, cityId);
    }

}
