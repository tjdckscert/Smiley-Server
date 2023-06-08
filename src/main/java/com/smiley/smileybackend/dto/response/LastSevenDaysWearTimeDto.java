package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.DailyWearTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
public class LastSevenDaysWearTimeDto {

    private LocalDate wearDate;

    private Integer totalWeartime;

    @Builder
    public LastSevenDaysWearTimeDto(LocalDate wearDate, Integer totalWeartime) {
        this.wearDate = wearDate;
        this.totalWeartime = totalWeartime;
    }

    public LastSevenDaysWearTimeDto(DailyWearTime saved) {
        this.wearDate = saved.getWearDate();
<<<<<<< HEAD
        this.totalWeartime = saved.getTotalWearTime();
=======
        this.totalWeartime = saved.getTotalWeartime();
>>>>>>> c7c4e1faf2834a8d81733cf6df300e9cdf52711c
    }

    public static LastSevenDaysWearTimeDto entitytoDto(DailyWearTime saved) {
        return new LastSevenDaysWearTimeDto(
                saved.getWearDate(),
<<<<<<< HEAD
                saved.getTotalWearTime()
=======
                saved.getTotalWeartime()
>>>>>>> c7c4e1faf2834a8d81733cf6df300e9cdf52711c
        );

    }

}
