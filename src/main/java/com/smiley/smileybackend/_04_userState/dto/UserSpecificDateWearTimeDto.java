package com.smiley.smileybackend._04_userState.dto;

import com.smiley.smileybackend._03_dailyWearTime.domain.DailyWearTime;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserSpecificDateWearTimeDto {

    private String userNumber;

    private LocalDate wearDate;

    private Integer totalWearTime;

    @Builder
    public UserSpecificDateWearTimeDto(DailyWearTime saved) {
        this.userNumber =saved.getUser().getUserNumber();
        this.wearDate = saved.getWearDate();
        this.totalWearTime=saved.getTotalWearTime();
    }
}
