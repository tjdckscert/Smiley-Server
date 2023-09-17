package com.smiley.smileybackend._05_hospital.dto;

import com.smiley.smileybackend._05_hospital.dto.HospitalGeocodingDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class HospitalGeocodingDtoList {
    List<HospitalGeocodingDto> hospitals;

    @Builder
    public HospitalGeocodingDtoList(List<HospitalGeocodingDto> hospitals) {
        this.hospitals = hospitals;
    }
}
