package com.example.travelagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    /*@Column(name = "city_id")
    private Long cityId;*/

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityModel city;
}
