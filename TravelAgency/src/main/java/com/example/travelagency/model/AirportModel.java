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
    @GeneratedValue
    private Long id;

    @Column(name = "airport")
    private String airportName;


    @Column(name = "city_id")
    private Long cityId;
}
