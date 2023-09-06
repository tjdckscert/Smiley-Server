package com.smiley.smileybackend._05_hospital.dto;

import com.smiley.smileybackend._05_hospital.dto.HospitalInfoDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@NoArgsConstructor
public class HospitalInfoDtoList {
    List<HospitalInfoDto> hospitals;

    @Builder
    public HospitalInfoDtoList(List<HospitalInfoDto> hospitals) {
        this.hospitals = hospitals;
    }
}
