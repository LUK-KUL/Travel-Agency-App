package com.example.travelagency.service;

import com.example.travelagency.enums.Continent;
import com.example.travelagency.enums.Country;
import com.example.travelagency.model.ContinentModel;
import com.example.travelagency.model.CountryModel;
import com.example.travelagency.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public void addCountry(CountryModel countryModel) {
        countryRepository.save(countryModel);
    }

    public void saveEditedCountry(CountryModel editedCountry) {
        countryRepository.save(editedCountry);
    }

    public void removeCountry(Long id) {
        countryRepository.deleteById(id);
    }

    public List<CountryModel> getAllCountries() {
        return countryRepository.findAll().stream().toList();
    }

    public CountryModel findCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    public List<CountryModel> findCountryByName(String name) {
        return countryRepository.findCountryByName(name);
    }

    public List<CountryModel> findCountryByContinent(Long continentId) {
        return countryRepository.findCountryByContinent(continentId);
    }

    public void updateCountryByName(Long id, String countryName) {
        countryRepository.updateCountryNameById(id, countryName);
    }

    public void updateCountryByContinent(Long id, Long continentId) {
        countryRepository.updateCountryContinentById(id, continentId);
    }
}
