package com.example.travelagency.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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


    @Column(name = "city_id")
    private Long cityId;
}
