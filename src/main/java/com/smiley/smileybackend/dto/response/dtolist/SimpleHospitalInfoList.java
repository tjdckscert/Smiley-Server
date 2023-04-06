package com.smiley.smileybackend.dto.response.dtolist;

import com.smiley.smileybackend.dto.response.SimpleHospitalInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class SimpleHospitalInfoList {
    List<SimpleHospitalInfo> simpleHospitalInfos;

    @Builder
    public SimpleHospitalInfoList(List<SimpleHospitalInfo> simpleHospitalInfos) {
        this.simpleHospitalInfos = simpleHospitalInfos;
    }
}
