package com.example.travelagency.model;

import com.example.travelagency.enums.Continent;
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
public class ContinentModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "continent")
    private Continent continentName;

    @OneToMany(mappedBy = "continent")
    private List<CountryModel> countries;
}
