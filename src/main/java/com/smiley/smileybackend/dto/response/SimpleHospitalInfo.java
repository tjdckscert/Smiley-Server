package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Hospital;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class SimpleHospitalInfo {
    private Integer id;
    private String name;
    private String dutyAddr;

    @Builder
    public SimpleHospitalInfo(Integer id, String name, String dutyAddr) {
        this.id = id;
        this.name = name;
        this.dutyAddr = dutyAddr;
    }

    @Builder
    public static SimpleHospitalInfo entityToDto(Hospital hospital){
        return new SimpleHospitalInfo(
        hospital.getId(),
        hospital.getName(),
        hospital.getDutyAddr()
        );
    }
}
