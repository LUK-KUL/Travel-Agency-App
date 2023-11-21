package com.example.travelagency.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class PurchaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int adultsQuantity;

    @Column
    private int childsQuantity;

    @Column
    @Formula("(adultsQuantity * trip.adultPrice) + (childsQuantity * trip.childPrice)")
    private BigDecimal totalCost;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private TripModel trip;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;

}
