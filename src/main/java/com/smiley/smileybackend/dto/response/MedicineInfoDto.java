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
    private String itemNameKorea;

    @ApiModelProperty( example = "제품명_영문")
    private String itemNameEnglish;

    @Builder
    public static MedicineInfoDto entityToDto(Medicine medicine){
        return new MedicineInfoDto(
                medicine.getItemCode(),
                medicine.getProfessionalism(),
                medicine.getItemNameKorea(),
                medicine.getItemNameEnglish()
        );
    }
    @Builder
    public MedicineInfoDto(Medicine saved) {
        this.itemCode = saved.getItemCode();
        this.professionalism =saved.getProfessionalism();
        this.professionalism=saved.getProfessionalism();
        this.itemNameKorea=saved.getItemNameKorea();
        this.itemNameEnglish=saved.getItemNameEnglish();
    }

    @Builder
    public MedicineInfoDto(String itemCode, String professionalism, String itemNameKorea, String itemNameEnglish) {
        this.itemCode = itemCode;
        this.professionalism = professionalism;
        this.itemNameKorea = itemNameKorea;
        this.itemNameEnglish = itemNameEnglish;
    }
}
