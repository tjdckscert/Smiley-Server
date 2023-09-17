package com.smiley.smileybackend._03_dailyWearTime.dto;

import com.smiley.smileybackend._03_dailyWearTime.dto.LastSevenDaysWearTimeDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class LastSevenDaysWearTimeDtoList {
    List<LastSevenDaysWearTimeDto> weartimes;

    @Builder
    public LastSevenDaysWearTimeDtoList(List<LastSevenDaysWearTimeDto> weartimes) {
        this.weartimes = weartimes;
    }
}
