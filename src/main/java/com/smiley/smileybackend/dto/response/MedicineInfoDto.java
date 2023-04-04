package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Medicine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class MedicineInfoDto {

    private Integer id;

    /**
     * 제품명
     * */
    private String itemName;

    /**
     * 전문성
     * */
    private String professionalism;

    /**
     * 품목기준코드
     * */
    private String itemCode;

    /**
     * 주성분
     * */
    private String mainIngredient;

    public MedicineInfoDto(Medicine saved) {
        this.id = saved.getId();
        this.itemName =saved.getItemName();
        this.professionalism=saved.getProfessionalism();
        this.itemCode=saved.getItemCode();
        this.mainIngredient=saved.getMainIngredient();
    }

    public MedicineInfoDto(Integer id, String itemName, String professionalism, String itemCode, String mainIngredient) {
        this.id = id;
        this.itemName = itemName;
        this.professionalism = professionalism;
        this.itemCode=itemCode;
        this.mainIngredient=mainIngredient;
    }

}
