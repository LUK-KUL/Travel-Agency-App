package com.example.travelagency.model;

import com.example.travelagency.enums.Continent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ContinentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "continent")
    private String continentName;

    //@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @OneToMany (mappedBy = "continent")
    @JsonIgnore
    private List<CountryModel> countries = new ArrayList<>();
}
