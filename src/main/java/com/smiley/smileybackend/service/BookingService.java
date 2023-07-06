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

    /**
     * 사용자의 예약 정보를 가져온다.
     *
     * @author : 김성찬
     * @param : 사용자 Index번호
     * @return : 예약 정보
     */    
    public UserBookingDtoList getBookings(Integer id){
        List<Booking> bookingDtos = bookingRepository.findByUser_Id(id);
        return new UserBookingDtoList(bookingRepository.findByUser_Id(id)
                .stream()
                .map(UserBookingDto::entityToDto)
                .collect(Collectors.toList())) ;
    }
}
