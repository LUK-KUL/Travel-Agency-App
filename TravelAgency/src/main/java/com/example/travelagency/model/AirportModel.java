package com.example.travelagency.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class AirportModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "airport")
    private String airportName;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityModel city;
}
