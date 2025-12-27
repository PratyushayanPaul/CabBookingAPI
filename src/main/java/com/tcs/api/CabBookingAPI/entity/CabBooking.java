package com.tcs.api.CabBookingAPI.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
//import javax.persistence.Column;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CabBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    private String source;
    private String destination;
    private Float fare;
    private LocalDate travelDate;

    @Column(nullable = false, length = 10)
    //@Size(max = 10, message = "Number cannot be longer than 10 digits.")
    //@Min(value = 10L, message = "Mobile number should be at least 10 digits.")
    //@Max(value = 10L, message = "Mobile number should be at least 10 digits.")
    //@Size(min = 10, max = 10, message = "Mobile number must be exactly 10 digits.")
    //@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits.")
    private Long userMobile;

    private Character status;

}
