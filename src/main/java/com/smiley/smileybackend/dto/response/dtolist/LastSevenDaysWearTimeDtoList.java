package com.smiley.smileybackend.dto.response.dtolist;

import com.smiley.smileybackend.dto.response.LastSevenDaysWearTimeDto;
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
