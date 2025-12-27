package com.tcs.api.CabBookingAPI.controller;


import com.tcs.api.CabBookingAPI.dto.CabBookingDTO;
import com.tcs.api.CabBookingAPI.entity.CabBooking;
import com.tcs.api.CabBookingAPI.service.BookingService;
import com.tcs.api.CabBookingAPI.service.BookingServiceImpl;
import jakarta.validation.Valid;
import org.hibernate.Internal;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabbooking")
@Validated
public class BookingController {

    private final BookingServiceImpl bookingServiceImpl;
    private Environment env;

    public BookingController(BookingServiceImpl bookingServiceImpl) {
        this.bookingServiceImpl = bookingServiceImpl;
    }


    @PostMapping("")
    public ResponseEntity<String> bookCab(@Valid @RequestBody CabBookingDTO cabBookingDTO){

        Integer bookingID = bookingServiceImpl.bookCab(cabBookingDTO);
        String successMessage = bookingServiceImpl.getBookingSuccessMessage(bookingID);
        return ResponseEntity.status(201).body(successMessage);
    }

    @GetMapping("/{mobileNo}")
    public ResponseEntity<List<CabBooking>> getBookingDetails(@PathVariable Long mobileNo, HttpMethod httpMethod){
        List <CabBooking> cabBookingDTOList = bookingServiceImpl.getBookingDetails(mobileNo);
        return new ResponseEntity<> (cabBookingDTOList,HttpStatus.CREATED);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable Integer bookingId){
        bookingServiceImpl.cancelBooking(bookingId);
        String cancelMessage = bookingServiceImpl.getBookingCancelMessage(bookingId);
        return ResponseEntity.status(201).body(cancelMessage);
    }
}
