package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Booking;
import com.smiley.smileybackend.dto.response.UserBookingDto;
import com.smiley.smileybackend.dto.response.dtolist.UserBookingDtoList;
import com.smiley.smileybackend.repository.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public UserBookingDtoList getBookings(Integer id){
        List<Booking> bookingDtos = bookingRepository.findByUser_Id(id);
        log.info((bookingRepository.findByUser_Id(id).get(0)).toString());
        return new UserBookingDtoList(bookingRepository.findByUser_Id(id)
                .stream()
                .map(UserBookingDto::entityToDto)
                .collect(Collectors.toList())) ;
    }
}
