package com.smiley.smileybackend._05_hospital.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class PartnerHospitalDtoList {
    List<PartnerHospitalDto> hospitals;

    @Builder
    public PartnerHospitalDtoList(List<PartnerHospitalDto> hospitals) {
        this.hospitals = hospitals;
    }
}
