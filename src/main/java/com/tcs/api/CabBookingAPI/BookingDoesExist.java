package com.tcs.api.CabBookingAPI;

public class BookingDoesExist extends RuntimeException {
    public BookingDoesExist(String message) {
        super(message);
    }
}
