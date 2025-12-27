package com.tcs.api.CabBookingAPI;

public class MobileNumberNotFoundException extends RuntimeException {
    public MobileNumberNotFoundException(String message) {
        super(message);
    }
}
