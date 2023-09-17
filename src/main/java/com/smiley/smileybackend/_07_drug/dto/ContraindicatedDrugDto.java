package com.smiley.smileybackend._07_drug.dto;


import com.smiley.smileybackend._07_drug.domain.ContraindicatedDrug;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class ContraindicatedDrugDto {

    @ApiModelProperty( example = "성분명_한글")
    private String itemNameKor;

    @ApiModelProperty( example = "성분명_영문")
    private String itemNameEng;

    @ApiModelProperty( example = "설명")
    private String itemDescription;

    @Builder
    public static ContraindicatedDrugDto entityToDto(ContraindicatedDrug contraindicatedDrug){
        return new ContraindicatedDrugDto(

                contraindicatedDrug.getItemNameKor(),
                contraindicatedDrug.getItemNameEng(),
                contraindicatedDrug.getItemDescription()
        );
    }
    @Builder
    public ContraindicatedDrugDto(ContraindicatedDrug saved) {

        this.itemNameKor =saved.getItemNameKor();
        this.itemNameEng =saved.getItemNameEng();
        this.itemDescription = saved.getItemDescription();

    }

    @Builder
    public ContraindicatedDrugDto(String itemNameKor, String itemNameEng, String itemSubstanceKor) {
        this.itemNameKor = this.itemNameKor;
        this.itemNameEng = this.itemNameEng;
        this.itemDescription = this.itemDescription;

    }


    public ContraindicatedDrug toEntity() {
        return ContraindicatedDrug.builder()
                .itemNameKor(itemNameKor)
                .itemNameEng(itemNameEng)
                .itemDescription(itemDescription)
                .build();
    }


}
