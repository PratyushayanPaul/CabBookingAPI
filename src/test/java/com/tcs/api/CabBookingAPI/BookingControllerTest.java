//package com.tcs.api.CabBookingAPI;
//
//import com.tcs.api.CabBookingAPI.controller.BookingController;
//import com.tcs.api.CabBookingAPI.dto.CabBookingDTO;
//import com.tcs.api.CabBookingAPI.service.BookingService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.mock;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(BookingController.class)
//public class BookingControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    //@MockBean
//    @MockitoBean
//    private BookingService bookingService;
//
//    @Test
//    void getCabBookingByNumber(){
//        CabBookingDTO cabBookingDTO = new CabBookingDTO("New York", );
//        when(bookingService.getBookingByNumber(9876543210L).thenReturn(cabBookingDTO);
//        mockMvc.perform(get("/cabbooking/9876543210")
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(1))
//                .andExpect(jsonPath("$[0].bookingId").value(4))));
//
//    }
//}
