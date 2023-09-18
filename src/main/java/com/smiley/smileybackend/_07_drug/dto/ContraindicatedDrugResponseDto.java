package com.smiley.smileybackend._07_drug.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@ToString
@Getter
@NoArgsConstructor
public class ContraindicatedDrugResponseDto {


    // 약이름
    @ApiModelProperty( example = "제품명_한글")
    private String itemNameKor;

    //금지 성분
    @ApiModelProperty( example = "금지성분 설명")
    private List<ContraindicatedDrugDto> contraindicatedDrugList;

    @Builder
    public ContraindicatedDrugResponseDto(String itemNameKor, List<ContraindicatedDrugDto> contraindicatedDrugList) {
        this.itemNameKor = itemNameKor;
        this.contraindicatedDrugList = contraindicatedDrugList;
    }

}
