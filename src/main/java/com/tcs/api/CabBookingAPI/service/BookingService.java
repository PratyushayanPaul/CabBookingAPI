package com.tcs.api.CabBookingAPI.service;

import com.tcs.api.CabBookingAPI.dto.CabBookingDTO;
import com.tcs.api.CabBookingAPI.entity.CabBooking;

import java.util.List;

public interface BookingService {
    Integer bookCab(CabBooking cabBooking);
    List<CabBookingDTO> getBookingDetails(Long mobileNo);
    public void cancelBooking(Integer bookingId);

    Object getBookingByNumber(Long i);
}
