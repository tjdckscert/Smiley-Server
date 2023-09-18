package com.smiley.smileybackend._06_booking.controller;

import com.smiley.smileybackend._06_booking.dto.UserBookingDto;
import com.smiley.smileybackend._06_booking.dto.UserBookingDtoList;
import com.smiley.smileybackend._06_booking.dto.BookingCancelInfoDto;
import com.smiley.smileybackend._06_booking.dto.BookingInfoDto;
import com.smiley.smileybackend._01_user.dto.user.UserMemoDto;
import com.smiley.smileybackend._00_common.exception.ErrorCode;
import com.smiley.smileybackend._06_booking.service.BookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@Api(tags = "Booking Controller : 예약 정보")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings/past/{userNumber}")
    @ApiOperation(value="사용자 정보 과거 예약 정보" , notes = "사용자의 과거 예약 정보들을 반환한다.")
    public ResponseEntity<UserBookingDtoList> pastBookingDtoLists(@PathVariable("userNumber") String userNumber){
        UserBookingDtoList bookings = bookingService.getPastBookings(userNumber);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/bookings/present/{userNumber}")
    @ApiOperation(value="사용자 정보 현재 예약 정보" , notes = "사용자의 현재 예약 정보들을 반환한다.")
    public ResponseEntity<UserBookingDtoList> presentBookingDtoLists(@PathVariable("userNumber") String userNumber){
        UserBookingDtoList bookings = bookingService.getPresentBookings(userNumber);
        return ResponseEntity.ok(bookings);
    }

    @PostMapping("/booking")
    @ApiOperation(value="사용자 예약" , notes = "사용자의 예약 정보를 저장한다.")
    @ApiResponse(response = ErrorCode.class, message = "1. 병원 ID를 확인할 수 없습니다. \n 2. 사용자 번호를 확인할 수 없습니다.", code = 423)
    public ResponseEntity<UserBookingDto> booking(@Valid @RequestBody BookingInfoDto bookingInfoDto){
        UserBookingDto userBookingInfoDto = bookingService.booking(bookingInfoDto);
        return ResponseEntity.ok(userBookingInfoDto);
    }

    @PatchMapping("/booking")
    @ApiOperation(value="사용자 예약 수정" , notes = "사용자의 예약 정보를 수정한다.")
    @ApiResponse(response = ErrorCode.class, message = "예약정보를 찾을 수 없습니다.", code = 423)
    public ResponseEntity<UserBookingDto> patchBooking(@Valid @RequestBody BookingInfoDto bookingInfoDto){
        UserBookingDto userBookingInfoDto = bookingService.bookingPatch(bookingInfoDto);
        return ResponseEntity.ok(userBookingInfoDto);
    }

    @DeleteMapping("/booking")
    @ApiOperation(value="사용자 예약 취소" , notes = "사용자의 예약을 취소한다.")
    @ApiResponse(message = "1.예약정보를 찾을 수 없습니다.\t\n 2.예약정보가 일치하지 않습니다.", code = 403)
    public ResponseEntity<UserBookingDto> cancelBooking(@Valid@RequestBody BookingCancelInfoDto bookingCancelInfoDto){
        UserBookingDto userBookingInfoDto = bookingService.cancelBooking(bookingCancelInfoDto);
        return ResponseEntity.ok(userBookingInfoDto);
    }

    @PostMapping("/bookings/memo")
    @ApiOperation(value="메모 수정/저장" , notes = "사용자의 예약에 대한 메모를 수정/저장한다.")
    @ApiResponse(response = ErrorCode.class, message = "예약정보를 찾을 수 없습니다.", code = 423)
    public ResponseEntity<UserBookingDto> patchMeno(@Valid @RequestBody UserMemoDto userMemoDto){
        log.info(userMemoDto.toString());
        UserBookingDto userBookingInfoDto = bookingService.patchMemo(userMemoDto);
        return ResponseEntity.ok(userBookingInfoDto);
    }
}
