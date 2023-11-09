package com.example.travelagency.model;

import jakarta.persistence.*;
import lombok.*;

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
