package com.example.travelagency.model;

import com.example.travelagency.enums.Continent;
import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CountryModel> countries;
}
