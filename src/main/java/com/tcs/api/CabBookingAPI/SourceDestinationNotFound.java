package com.tcs.api.CabBookingAPI;

public class SourceDestinationNotFound extends RuntimeException {
    public SourceDestinationNotFound(String message) {
        super(message);
    }
}
