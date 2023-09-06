package com.smiley.smileybackend._05_hospital.dto;

import com.smiley.smileybackend._05_hospital.dto.SimpleHospitalInfoDto;
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
