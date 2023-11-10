package com.example.travelagency.model;

import com.example.travelagency.enums.Continent;
import com.example.travelagency.enums.Country;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CountryModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "country")
    private String countryName;


    @Column(name = "continent_id")
    private Long continentId;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CityModel> city;
}
