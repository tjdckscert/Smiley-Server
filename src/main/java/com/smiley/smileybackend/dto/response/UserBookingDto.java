package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Booking;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserBookingDto {

    private Integer id;

    private LocalDateTime reserveDate;

    private String memo;

    private String userNumber;

    private String hPid;

    private String dutyAddr;

    private String dutyName;

    private String dutyTel;

    /*병원경도*/
    private String wgs84Lon;

    /*병원위도*/
    private String wgs84Lat;

    @Builder
    public UserBookingDto(Integer id, LocalDateTime reserveDate, String memo, String userNumber, String hPid, String dutyAddr, String dutyName, String dutyTel, String wgs84Lon, String wgs84Lat) {
        this.id = id;
        this.reserveDate = reserveDate;
        this.memo = memo;
        this.userNumber = userNumber;
        this.hPid = hPid;
        this.dutyAddr = dutyAddr;
        this.dutyName = dutyName;
        this.dutyTel = dutyTel;
        this.wgs84Lon = wgs84Lon;
        this.wgs84Lat = wgs84Lat;
    }

    public static UserBookingDto entityToDto(Booking booking){
        return new UserBookingDto(
                booking.getId(),
                booking.getReservDate(),
                booking.getMemo(),
                booking.getUser().getUserNumber(),
                booking.getHospital().getHPid(),
                booking.getHospital().getDutyAddr(),
                booking.getHospital().getDutyName(),
                booking.getHospital().getDutyTel1(),
                booking.getHospital().getWgs84Lon(),
                booking.getHospital().getWgs84Lat()
        );
    }
}
