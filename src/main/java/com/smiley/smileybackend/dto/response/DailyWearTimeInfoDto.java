package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.DailyWearTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@ToString
public class DailyWearTimeInfoDto {

    private Integer id;

    private Integer userId;

    private LocalDate wearDate;

    private Integer totalWearTime;

    @Builder
    public DailyWearTimeInfoDto(DailyWearTime saved) {
        this.id = saved.getId();
        this.userId=saved.getId();
        this.wearDate = saved.getWearDate();
        this.totalWearTime=saved.getTotalWearTime();
    }

    @Builder
    public DailyWearTimeInfoDto(Integer id, Integer userId, LocalDate wearDate, Integer totalWearTime) {
        this.id = id;
        this.userId = userId;
        this.wearDate = wearDate;
        this.totalWearTime = totalWearTime;
    }

}
