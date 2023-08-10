package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Booking;
import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.dto.response.UserBookingDto;
import com.smiley.smileybackend.dto.response.dtolist.UserBookingDtoList;
import com.smiley.smileybackend.dto.user.BookingCancelInfoDto;
import com.smiley.smileybackend.dto.user.BookingInfoDto;
import com.smiley.smileybackend.dto.user.PatchBookingDto;
import com.smiley.smileybackend.dto.user.UserMemoDto;
import com.smiley.smileybackend.exception.ErrorCode;
import com.smiley.smileybackend.exception.ErrorException;
import com.smiley.smileybackend.repository.BookingRepository;
import com.smiley.smileybackend.repository.HospitalRepository;
import com.smiley.smileybackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Slf4j
public class BookingService {

    private final BookingRepository bookingRepository;

    private final UserRepository userRepository;

    private final HospitalRepository hospitalRepository;

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, HospitalRepository hospitalRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.hospitalRepository = hospitalRepository;
    }

    /**
     * 사용자의 과거 예약 정보를 반환 한다.
     *
     * @author : 김성찬
     * @param : 사용자 Index번호
     * @return : 예약 정보
     */    
    public UserBookingDtoList getPastBookings(String userNumber){
        return new UserBookingDtoList(bookingRepository.findPastBooking(userNumber)
                .stream()
                .map(UserBookingDto::entityToDto)
                .collect(Collectors.toList())) ;
    }

    /**
     * 사용자의 현재 예약 정보를 반환 한다.
     *
     * @author : 김성찬
     * @param : 사용자 Index번호
     * @return : 예약 정보
     */
    public UserBookingDto getPresentBookings(String userNumber) {
        Booking booking = bookingRepository.findPresentBooking(userNumber);
        log.info(booking.toString());
        return UserBookingDto.entityToDto(bookingRepository.findPresentBooking(userNumber));
    }

    /**
     * 사용자의 예약 정보를 저장 한다.
     *
     * @author : 김성찬
     * @param : 사용자 예약 정보
     * @return : 예약 정보
     */
    public UserBookingDto booking(BookingInfoDto bookingInfoDto) {
        Booking booking = bookingRepository.save(bookingInfoDto.toEntity(getUser(bookingInfoDto.getUserNumber()),getHospital(bookingInfoDto.getHPid())));
        return UserBookingDto.entityToDto(booking);
    }

    /**
     * 사용자의 예약에 대한 메모를 저장한다.
     *
     * @author : 김성찬
     * @param : 사용자 메모
     * @return : 메모 정보
     */
    public UserBookingDto patchMemo(UserMemoDto userMemoDto) {
        Booking booking = bookingRepository.findById(userMemoDto.getId()).orElseThrow(
                () -> new ErrorException(ErrorCode.BOOKING_NOT_FOUND)
        );
        booking.setMemo(userMemoDto.getMemo());
        bookingRepository.save(booking);
        return UserBookingDto.entityToDto(booking);

    }
    public UserBookingDto cancelBooking(BookingCancelInfoDto bookingCancelInfoDto) {
        Booking booking = bookingRepository.findById(bookingCancelInfoDto.getId()).orElseThrow(
                () -> new ErrorException(ErrorCode.BOOKING_NOT_FOUND)
        );
        if (booking.getUser().getUserNumber().equals(bookingCancelInfoDto.getUserNumber())) bookingRepository.delete(booking);
        else throw new ErrorException(ErrorCode.BOOKING_INFORMATION_NOT_MATCH);
        return UserBookingDto.entityToDto(booking);
    }

    public UserBookingDto bookingPatch(PatchBookingDto patchBookingDto) {
        Booking booking = bookingRepository.findById(patchBookingDto.getId()).orElseThrow(
                ()->new ErrorException(ErrorCode.BOOKING_NOT_FOUND)
        );
        booking.patchBooking(patchBookingDto,getHospital(patchBookingDto.getHPid()));
        bookingRepository.save(booking);
        return UserBookingDto.entityToDto(booking);
    }

    public User getUser(String userNumber){
        return userRepository.findById(userNumber).orElseThrow(
                () -> new ErrorException(ErrorCode.USER_NOT_FOUND)
        );
    }

    public Hospital getHospital(String hPid){
        return hospitalRepository.findByHPid(hPid).orElseThrow(
                () -> new ErrorException(ErrorCode.HOSPITAL_NOT_FOUND)
        );
    }


}
