package com.smiley.smileybackend.dto.response.dtolist;

import com.smiley.smileybackend.dto.response.SimpleHospitalInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class SimpleHospitalInfoDtoList {
    List<SimpleHospitalInfo> hospitals;

    @Builder
    public SimpleHospitalInfoDtoList(List<SimpleHospitalInfo> hospitals) {
        this.hospitals = hospitals;
    }
}
