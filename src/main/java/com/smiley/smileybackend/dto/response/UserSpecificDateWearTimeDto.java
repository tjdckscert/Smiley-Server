package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.DailyWearTime;
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
