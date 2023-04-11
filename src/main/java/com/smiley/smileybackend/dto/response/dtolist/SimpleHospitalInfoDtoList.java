package com.smiley.smileybackend.dto.response.dtolist;

import com.smiley.smileybackend.dto.response.SimpleHospitalInfoDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class SimpleHospitalInfoDtoList {
    List<SimpleHospitalInfoDto> hospitals;

    @Builder
    public SimpleHospitalInfoDtoList(List<SimpleHospitalInfoDto> hospitals) {
        this.hospitals = hospitals;
    }
}
