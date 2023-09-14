package com.smiley.smileybackend._05_hospital.dto;

import com.smiley.smileybackend._05_hospital.domain.Hospital;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class PartnerHospitalDto {  //제휴 병원
    @ApiModelProperty( example = "병원 ID")
    private String hPid;

    @ApiModelProperty(example = "병원이름")
    private String dutyName;
    @ApiModelProperty(example = "병원주소")
    private String dutyAddr;

    @ApiModelProperty( example = "사용자 위도")
    private Double latitude;

    @ApiModelProperty( example = "사용자 경도")
    private Double longitude;
    @Builder
    public PartnerHospitalDto(String hPid, String dutyName, String dutyAddr, Double latitude, Double longitude) {
        this.hPid = hPid;
        this.dutyName = dutyName;
        this.dutyAddr = dutyAddr;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Builder
    public static PartnerHospitalDto entityToDto(Hospital hospital){
        return new PartnerHospitalDto(
                hospital.getHPid(),
                hospital.getDutyName(),
                hospital.getDutyAddr(),
                Double.parseDouble(hospital.getWgs84Lat()),
                Double.parseDouble(hospital.getWgs84Lon())
        );
    }
}
