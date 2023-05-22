package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Booking;
import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@ToString
@NoArgsConstructor
public class UserBookingDto {

    private Integer id;

    private OffsetDateTime reserveDate;

    private String memo;

    private String userId;

    private String hPid;

    @Builder
    public UserBookingDto(Integer id, OffsetDateTime reserveDate, String memo, String userId, String hPid) {
        this.id = id;
        this.reserveDate = reserveDate;
        this.memo = memo;
        this.userId = userId;
        this.hPid = hPid;
    }

    public static UserBookingDto entityToDto(Booking booking){
        return new UserBookingDto(
                booking.getId(),
                booking.getReservDate(),
                booking.getMemo(),
                booking.getUser().getId().toString(),
                booking.getHospital().getHPid()
        );
    }
}
