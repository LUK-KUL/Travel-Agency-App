package com.example.travelagency.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class TripModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "city_from")
    private String cityFrom;

    @Column(name = "city_to")
    private String cityTo;

    @Column(name = "airport_from")
    private String airportFrom;

    @Column(name = "airport_to")
    private String airportTo;

    @Column(name = "start_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Column(name = "trip_length")
    @Formula("DAYS_BETWEEN(start_date, end_date)")
    private byte tripLength;

    @Column(name = "adult_price")
    private BigDecimal adultPrice;

    @Column(name = "child_price")
    private BigDecimal childPrice;

    @Column(name = "child_available_places")
    private int childPlaces;

    @Column(name = "adult_available_places")
    private int adultPlaces;

    @Column(name = "trip_availability")
    private boolean isAvailable;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PurchaseModel> purchases;

    public void updateAvailability(){
        if (adultPlaces>0){
            isAvailable = true;
        }else isAvailable = false;
    }

}
