package com.smiley.smileybackend.dto.response.dtolist;

import com.smiley.smileybackend.dto.response.HospitalGeocodingDto;
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
