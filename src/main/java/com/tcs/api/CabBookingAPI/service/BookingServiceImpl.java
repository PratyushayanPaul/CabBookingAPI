package com.tcs.api.CabBookingAPI.service;

import com.tcs.api.CabBookingAPI.BookingDoesExist;
import com.tcs.api.CabBookingAPI.MobileNumberNotFoundException;
import com.tcs.api.CabBookingAPI.SourceDestinationNotFound;
import com.tcs.api.CabBookingAPI.dto.CabBookingDTO;
import com.tcs.api.CabBookingAPI.entity.CabBooking;
import com.tcs.api.CabBookingAPI.entity.FareEstimation;
import com.tcs.api.CabBookingAPI.repository.CabBookingRepository;
import com.tcs.api.CabBookingAPI.repository.FareEstimationRepository;
import org.hibernate.Internal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.core.env.Environment;

import java.util.List;

@Service
public class BookingServiceImpl {

    private final CabBookingRepository cabBookingRepository;
    private final FareEstimationRepository fareEstimationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final Environment env;

    public BookingServiceImpl(CabBookingRepository cabBookingRepository, FareEstimationRepository fareEstimationRepository, Environment env) {
        this.cabBookingRepository = cabBookingRepository;
        this.fareEstimationRepository = fareEstimationRepository;
        this.env = env;
    }

    public String getBookingSuccessMessage(Integer bookingId) {
        String successMessage = env.getProperty("API.BOOKING_SUCCESSFUL");
        if (successMessage != null) {
            return successMessage + bookingId;
        } else {
            return "Success message not found, booking ID: " + bookingId;
        }
    }

    public String getBookingCancelMessage(Integer bookingId) {
        String cancelMessage = env.getProperty("API.BOOKING_CANCELLED");
        if (cancelMessage != null) {
            return cancelMessage + bookingId;
        } else {
            return "Cancel message not found, booking ID: " + bookingId;
        }
    }

    public Integer bookCab(CabBookingDTO cabBookingDTO){
        //CabBooking cabBooking1 = modelMapper.map(cabBooking, CabBooking.class);
        FareEstimation fareEstimation = fareEstimationRepository.getFareEstimationBySourceAndDestination(cabBookingDTO.getSource(),cabBookingDTO.getDestination());

        if(fareEstimation!=null){
            Float fare = fareEstimation.getFare();
            CabBooking cabBooking1 = new CabBooking();
            cabBooking1.setDestination(cabBookingDTO.getDestination());
            cabBooking1.setSource(cabBookingDTO.getSource());
            cabBooking1.setFare(fare);
            cabBooking1.setStatus('B');
            cabBooking1.setTravelDate(cabBookingDTO.getTravelDate());
            cabBooking1.setUserMobile(cabBookingDTO.getUserMobile());

            CabBooking cabBooking2 = cabBookingRepository.save(cabBooking1);
            return cabBooking2.getBookingId();
        }
        else{
            throw new SourceDestinationNotFound("This source and destination doesn't exist");
        }


    }

    public List<CabBooking> getBookingDetails(Long mobileNo){
        if(cabBookingRepository.existsByUserMobile(mobileNo)){
            return cabBookingRepository.findCabBookingByUserMobile(mobileNo);
        }
        else{
            throw new MobileNumberNotFoundException("Mobile number doesn't exist");
        }
    }

    public void cancelBooking(Integer bookingId) {
        if(cabBookingRepository.existsById(bookingId)){
            //cabBookingRepository.deleteById(bookingId);

            CabBooking cabBooking = cabBookingRepository.findCabBookingByBookingId(bookingId);

            cabBooking.setStatus('C');
            cabBookingRepository.save(cabBooking);
        }
        else{
            throw new BookingDoesExist("Booking doesn't exist");
        }
    }
}