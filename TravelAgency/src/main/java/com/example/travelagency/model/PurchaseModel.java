package com.example.travelagency.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class PurchaseModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int adultsQuantity;

    @Column
    private int childsQuantity;

    @Column
    @Formula("(adultsQuantity * tripModel.adultPrice) + (childsQuantity * tripModel.childPrice)")
    private BigDecimal totalCost;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private TripModel trip;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;

}
