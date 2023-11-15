package com.example.travelagency.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString


public class AirportModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "airport")
    private String airportName;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityModel city;
}
