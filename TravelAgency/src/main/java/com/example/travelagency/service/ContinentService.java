package com.example.travelagency.service;

import com.example.travelagency.enums.Continent;
import com.example.travelagency.enums.Country;
import com.example.travelagency.model.ContinentModel;
import com.example.travelagency.repository.ContinentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContinentService {
    private final ContinentRepository continentRepository;
    public void addContinent(ContinentModel continentModel) {
        continentRepository.save(continentModel);
    }

    public void saveEditedContinent(ContinentModel editedContinent) {
        continentRepository.save(editedContinent);
    }

    public void removeContinent(Long id) {
        continentRepository.deleteById(id);
    }

    public List<ContinentModel> getAllContinent() {
        return continentRepository.findAll().stream().toList();
    }

    public ContinentModel findContinentById(Long id) {
        return continentRepository.findById(id).orElse(null);
    }

    public List<ContinentModel> findContinentByName(String continentName) {
        return continentRepository.findContinentByName(continentName);
    }
}
