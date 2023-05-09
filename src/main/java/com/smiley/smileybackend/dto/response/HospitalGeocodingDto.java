package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Hospital;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@NoArgsConstructor
public class HospitalGeocodingDto {
    @ApiModelProperty( example = "병원 ID")
    private String hPid;

    @ApiModelProperty( example = "사용자 위도")
    private Double latitude;

    @ApiModelProperty( example = "사용자 경도")
    private Double longitude;

    @Builder
    public HospitalGeocodingDto(String hPid, Double latitude, Double longitude) {
        this.hPid = hPid;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Builder
    public static HospitalGeocodingDto entityToDto(Hospital hospital){
        return new HospitalGeocodingDto(
                hospital.getHPid(),
                Double.parseDouble(hospital.getWgs84Lat()),
                Double.parseDouble(hospital.getWgs84Lon())
        );
    }
}
