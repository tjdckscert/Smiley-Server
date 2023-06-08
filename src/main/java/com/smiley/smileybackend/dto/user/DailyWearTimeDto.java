package com.smiley.smileybackend.dto.user;

import com.smiley.smileybackend.domain.DailyExpStastics;
import com.smiley.smileybackend.domain.DailyWearTime;
import com.smiley.smileybackend.domain.TotalExpStastics;
import com.smiley.smileybackend.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class DailyWearTimeDto {

    @NotNull
    @ApiModelProperty(value = "사용자 ID(user의 index번호). 공백 X")
    private Integer userId;

    @NotNull
    @ApiModelProperty(value = "착용날짜 / 입력 양식은 'yyyy-mm-dd")
    private LocalDate wearDate;

    @NotNull
    @ApiModelProperty(value = "착용시간 / 단위는 분 ex) 162분")
    private Integer totalWearTime;


    public DailyWearTime toEntity(User user) {
        return DailyWearTime.builder()
                .user(user)
                .wearDate(wearDate)
                .totalWearTime(totalWearTime)
                .build();
    }
    public DailyExpStastics toDailyExpEntity(User user) {
        return DailyExpStastics.builder()
                .user(user)
                .date(wearDate)
                .build();
    }
}
