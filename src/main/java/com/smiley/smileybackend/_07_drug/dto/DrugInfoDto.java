package com.smiley.smileybackend._07_drug.dto;

import com.smiley.smileybackend._07_drug.domain.Drug;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@Setter
public class DrugInfoDto {

    @ApiModelProperty( example = "품목기준코드")
    private String itemCode;

    @ApiModelProperty( example = "제품명_한글")
    private String itemNameKor;

    @ApiModelProperty( example = "제품명_영문")
    private String itemNameEng;

    @ApiModelProperty( example = "주성분_한글")
    private String itemSubstanceKor;

    @ApiModelProperty( example = "주성분_영문")
    private String itemSubstanceEng;

    @ApiModelProperty( example = "전문성")
    private String professionalism;

    @ApiModelProperty( example = "복용_가능_여부")
    private boolean isSafeForConsumption;

    @Builder
    public static DrugInfoDto entityToDto(Drug drug){
        return new DrugInfoDto(
                drug.getItemCode(),
                drug.getItemNameKor(),
                drug.getItemNameEng(),
                drug.getItemSubstanceKor(),
                drug.getItemSubstanceEng(),
                drug.getProfessionalism(),
                drug.isSafeForConsumption()
        );
    }
    @Builder
    public DrugInfoDto(Drug saved) {
        this.itemCode = saved.getItemCode();
        this.itemNameKor =saved.getItemNameKor();
        this.itemNameEng =saved.getItemNameEng();
        this.itemSubstanceKor = saved.getItemSubstanceKor();
        this.itemSubstanceEng = saved.getItemSubstanceEng();
        this.professionalism = saved.getProfessionalism();
        this.isSafeForConsumption = saved.isSafeForConsumption();
    }

    @Builder
    public DrugInfoDto(String itemCode, String itemNameKor, String itemNameEng, String itemSubstanceKor, String itemSubstanceEng, String professionalism, boolean isSafeForConsumption) {
        this.itemCode = itemCode;
        this.itemNameKor = itemNameKor;
        this.itemNameEng = itemNameEng;
        this.itemSubstanceKor = itemSubstanceKor;
        this.itemSubstanceEng = itemSubstanceEng;
        this.professionalism = professionalism;
        this.isSafeForConsumption = isSafeForConsumption;
    }
}
