package com.example.travelagency.model;

import com.example.travelagency.enums.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CityModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "city")
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryModel country;

    @OneToMany(mappedBy = "city")
    private List<HotelModel> hotel;

    @OneToMany(mappedBy = "city")
    private List<AirportModel> airport;
}
