package com.smiley.smileybackend._01_user.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PatchBookingDto {

    @ApiModelProperty(value = "예약번호. 공백 X")
    private Integer id;

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
    public PatchBookingDto(Integer id, String userNumber, LocalDateTime reservDate, String memo, String hPid) {
        this.id = id;
        this.userNumber = userNumber;
        this.reservDate = reservDate;
        this.memo = memo;
        this.hPid = hPid;
    }

}
