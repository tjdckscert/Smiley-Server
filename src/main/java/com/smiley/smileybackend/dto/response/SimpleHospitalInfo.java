package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Hospital;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class SimpleHospitalInfo {
   @ApiModelProperty( example = "인덱스/Integer")
    private Integer id;

    @ApiModelProperty(example = "병원이름")
    private String name;
    @ApiModelProperty(example = "병원주소")
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
