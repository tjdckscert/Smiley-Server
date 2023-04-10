package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Medicine;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class MedicineInfoDto {
    
    @ApiModelProperty( example = "품목기준코드")
    private String itemCode;

    @ApiModelProperty( example = "전문성")
    private String professionalism;

    @ApiModelProperty( example = "제품명_한글")
    private String itemNameKor;

    @ApiModelProperty( example = "제품명_영문")
    private String itemNameEng;

    @Builder
    public static MedicineInfoDto entityToDto(Medicine medicine){
        return new MedicineInfoDto(
                medicine.getItemCode(),
                medicine.getProfessionalism(),
                medicine.getItemNameKor(),
                medicine.getItemNameEng()
        );
    }
    @Builder
    public MedicineInfoDto(Medicine saved) {
        this.itemCode = saved.getItemCode();
        this.professionalism =saved.getProfessionalism();
        this.professionalism=saved.getProfessionalism();
        this.itemNameKor =saved.getItemNameKor();
        this.itemNameEng =saved.getItemNameEng();
    }

    @Builder
    public MedicineInfoDto(String itemCode, String professionalism, String itemNameKor, String itemNameEng) {
        this.itemCode = itemCode;
        this.professionalism = professionalism;
        this.itemNameKor = itemNameKor;
        this.itemNameEng = itemNameEng;
    }
}
