package com.smiley.smileybackend.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smiley.smileybackend.domain.Booking;
import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookingInfoDto {

    @NotNull
    @ApiModelProperty(value = "사용자 ID(user의 index번호). 공백 X")
    private Integer userId;

    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    @ApiModelProperty(value = "예약 날짜 및 시간, 공백 X")
    private LocalDateTime reservDate;

    @ApiModelProperty(value = "예약 메모 사항, 공백 O")
    private String memo;

    @ApiModelProperty(value = "예약한 병원 hPid, 공백 X")
    private String hPid;

    public BookingInfoDto(Integer userId, LocalDateTime reservDate, String memo, String hPid) {
        this.userId = userId;
        this.reservDate = reservDate;
        this.memo = memo;
        this.hPid = hPid;
    }

    public Booking toEntity(User user, Hospital hospital){
        return Booking.builder()
                .reservDate(reservDate)
                .user(user)
                .hospital(hospital).build();
    }
}
