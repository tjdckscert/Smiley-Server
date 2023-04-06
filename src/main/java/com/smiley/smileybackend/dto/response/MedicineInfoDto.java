package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Medicine;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class MedicineInfoDto {

    @ApiModelProperty( example = "인덱스/Integer")
    private Integer id;

    @ApiModelProperty( example = "의약품이름")
    private String itemName;

    @ApiModelProperty( example = "전문성")
    private String professionalism;

    @ApiModelProperty( example = "의약품기준코드")
    private String itemCode;

    @ApiModelProperty( example = "주성분")
    private String mainIngredient;

    @Builder
    public static MedicineInfoDto entityToDto(Medicine medicine){
        return new MedicineInfoDto(
                medicine.getId(),
                medicine.getItemName(),
                medicine.getProfessionalism(),
                medicine.getItemCode(),
                medicine.getMainIngredient()
        );
    }
    @Builder
    public MedicineInfoDto(Medicine saved) {
        this.id = saved.getId();
        this.itemName =saved.getItemName();
        this.professionalism=saved.getProfessionalism();
        this.itemCode=saved.getItemCode();
        this.mainIngredient=saved.getMainIngredient();
    }

    @Builder
    public MedicineInfoDto(Integer id, String itemName, String professionalism, String itemCode, String mainIngredient) {
        this.id = id;
        this.itemName = itemName;
        this.professionalism = professionalism;
        this.itemCode=itemCode;
        this.mainIngredient=mainIngredient;
    }
}
