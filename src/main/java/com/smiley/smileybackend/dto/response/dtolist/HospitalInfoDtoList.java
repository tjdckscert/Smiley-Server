package com.smiley.smileybackend.dto.response.dtolist;

import com.smiley.smileybackend.dto.response.HospitalInfoDto;
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
