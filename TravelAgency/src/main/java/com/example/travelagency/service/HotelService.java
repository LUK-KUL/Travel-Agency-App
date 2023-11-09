package com.example.travelagency.service;

import com.example.travelagency.model.CityModel;
import com.example.travelagency.model.HotelModel;
import com.example.travelagency.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    public void addHotel(HotelModel hotelModel) {
        hotelRepository.save(hotelModel);
    }

    public void saveEditedHotel(HotelModel editedHotel) {
        hotelRepository.save(editedHotel);
    }

    public void removeHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    public List<HotelModel> getAllHotels() {
        return hotelRepository.findAll().stream().toList();
    }

    public HotelModel findHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public List<HotelModel> findHotelByCity(CityModel city) {
        return hotelRepository.findHotelByCity(city.getId());
    }

}
