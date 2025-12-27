package com.tcs.api.CabBookingAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({MobileNumberNotFoundException.class})
    public ResponseEntity<String> handleMobileNumberNotFoundException(MobileNumberNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({BookingDoesExist.class})
    public ResponseEntity<String> handleBookingDoesExist(BookingDoesExist ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({SourceDestinationNotFound.class})
    public ResponseEntity<String> handleSourceDestinationNotFound(SourceDestinationNotFound ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
