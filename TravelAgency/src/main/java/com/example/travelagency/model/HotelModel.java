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
public class HotelModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "hotel")
    private String hotelName;

    @Column(name = "standard")
    private byte standard;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityModel city;
}
