package com.tcs.api.CabBookingAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data

public class FareEstimation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fareId;

    private String source;
    private String destination;
    private Float fare;
}
