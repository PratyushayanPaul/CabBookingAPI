package com.tcs.api.CabBookingAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabBookingDTO {


    private String source;
    private String destination;
    private LocalDate travelDate;
    private Long userMobile;
}
