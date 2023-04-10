package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Hospital;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class SimpleHospitalInfo {
   @ApiModelProperty( example = "병원 ID")
    private String hPid;

    @ApiModelProperty(example = "병원이름")
    private String dutyName;
    @ApiModelProperty(example = "병원주소")
    private String dutyAddr;

    @Builder
    public SimpleHospitalInfo(String hPid, String dutyName, String dutyAddr) {
        this.hPid = hPid;
        this.dutyName = dutyName;
        this.dutyAddr = dutyAddr;
    }

    @Builder
    public static SimpleHospitalInfo entityToDto(Hospital hospital){
        return new SimpleHospitalInfo(
        hospital.getHPid(),
        hospital.getDutyName(),
        hospital.getDutyAddr()
        );
    }
}
