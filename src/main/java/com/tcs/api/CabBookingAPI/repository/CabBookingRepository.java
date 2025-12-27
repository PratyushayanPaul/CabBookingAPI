package com.tcs.api.CabBookingAPI.repository;

import com.tcs.api.CabBookingAPI.dto.CabBookingDTO;
import com.tcs.api.CabBookingAPI.entity.CabBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CabBookingRepository extends JpaRepository<CabBooking, Integer> {

    List<CabBooking> findCabBookingByUserMobile(Long userMobile);

    CabBooking findCabBookingByBookingId(Integer bookingId);

    boolean getCabBookingsByBookingId(Integer bookingId);

    boolean existsByUserMobile(Long mobileNo);


}
