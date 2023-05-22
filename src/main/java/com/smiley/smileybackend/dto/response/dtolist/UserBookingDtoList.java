package com.smiley.smileybackend.dto.response.dtolist;

import com.smiley.smileybackend.dto.response.UserBookingDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class UserBookingDtoList {
    List<UserBookingDto> bookings;

    @Builder
    public UserBookingDtoList(List<UserBookingDto> bookings) {
        this.bookings = bookings;
    }
}
