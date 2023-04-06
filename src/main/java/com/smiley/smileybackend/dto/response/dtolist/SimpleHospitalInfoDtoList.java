package com.smiley.smileybackend.dto.response.dtolist;

import com.smiley.smileybackend.dto.response.SimpleHospitalInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class SimpleHospitalInfoDtoList {
    List<SimpleHospitalInfo> simpleHospitalInfos;

    @Builder
    public SimpleHospitalInfoDtoList(List<SimpleHospitalInfo> simpleHospitalInfos) {
        this.simpleHospitalInfos = simpleHospitalInfos;
    }
}
