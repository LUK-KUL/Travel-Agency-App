package com.example.travelagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    @Formula("(adultsQuantity * tripModel.adultPrice) + (childsQuantity * tripModel.childPrice)")
    private BigDecimal totalCost;

    /*@Column(name = "trip_id")
    private Long tripId;*/

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private TripModel trip;

    /*@Column(name = "client_id")
    private Long clientId;*/

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;

}
