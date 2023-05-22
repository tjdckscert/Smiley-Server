package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.domain.Booking;
import com.smiley.smileybackend.dto.response.dtolist.UserBookingDtoList;
import com.smiley.smileybackend.service.BookingService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Booking Controller : 예약 정보")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<UserBookingDtoList> bookingdtolists(@PathVariable Integer id){
        UserBookingDtoList bookings = bookingService.getBookings(id);
        return ResponseEntity.ok(bookings);
    }
}
