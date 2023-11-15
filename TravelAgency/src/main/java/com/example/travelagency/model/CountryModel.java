package com.example.travelagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "continent_id")
    private ContinentModel continent;

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<CityModel> city;
}
