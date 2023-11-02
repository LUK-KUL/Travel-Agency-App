package com.example.travelagency.model;

import com.example.travelagency.enums.Continent;
import com.example.travelagency.enums.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CountryModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column (name = "country")
    private Country countryName;

    @ManyToOne
    @JoinColumn(name = "continent_id")
    private ContinentModel continent;

    @OneToMany(mappedBy = "country")
    private List<CityModel> city;
}
