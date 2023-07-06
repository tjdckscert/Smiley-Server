package com.smiley.smileybackend.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@ToString
@Setter
public class UserGeocodingDto {
    @NotNull(message = "위도의 값을 가져오지 못 하였습니다")
    @ApiModelProperty(value = "사용자 위도값. 공백 X")
    private Double latitude;

    @NotNull(message = "경도의 값을 가져오지 못 하였습니다")
    @ApiModelProperty(value = "사용자 경도값. 공백 X")
    private Double longitude;

    @NotNull(message = "검색할 거리를 입력해 주세요")
    @ApiModelProperty(value = "원하는 반경 거리. 공백 X")
    private Double distance;

    @Builder
    public UserGeocodingDto(Double latitude, Double longitude, Double distance) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
    }
}