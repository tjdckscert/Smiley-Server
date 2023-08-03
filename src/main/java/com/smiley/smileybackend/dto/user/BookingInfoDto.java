package com.smiley.smileybackend.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smiley.smileybackend.domain.Booking;
import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookingInfoDto {

    @NotBlank(message = "회원번호를 확인할 수 없습니다.")
    @ApiModelProperty(value = "사용자 회원번호(KAKAO,GOOGLE). 공백 X")
    private String userNumber;

    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    @ApiModelProperty(value = "예약 날짜 및 시간, 공백 X")
    private LocalDateTime reservDate;

    @ApiModelProperty(value = "예약 메모 사항, 공백 O")
    private String memo;

    @ApiModelProperty(value = "예약한 병원 hPid, 공백 X")
    private String hPid;

    @Builder
    public BookingInfoDto(String userNumber, LocalDateTime reservDate, String memo, String hPid) {
        this.userNumber = userNumber;
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
