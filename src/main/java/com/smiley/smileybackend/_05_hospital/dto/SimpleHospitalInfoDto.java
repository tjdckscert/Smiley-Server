package com.smiley.smileybackend._05_hospital.dto;

import com.smiley.smileybackend._05_hospital.domain.Hospital;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class SimpleHospitalInfoDto {
   @ApiModelProperty( example = "병원 ID")
    private String hPid;

    @ApiModelProperty(example = "병원이름")
    private String dutyName;
    @ApiModelProperty(example = "병원주소")
    private String dutyAddr;

    @Builder
    public SimpleHospitalInfoDto(String hPid, String dutyName, String dutyAddr) {
        this.hPid = hPid;
        this.dutyName = dutyName;
        this.dutyAddr = dutyAddr;
    }

    @Builder
    public static SimpleHospitalInfoDto entityToDto(Hospital hospital){
        return new SimpleHospitalInfoDto(
        hospital.getHPid(),
        hospital.getDutyName(),
        hospital.getDutyAddr()
        );
    }
}
