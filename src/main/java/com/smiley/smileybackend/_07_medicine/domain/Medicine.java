package com.smiley.smileybackend._07_medicine.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.json.JSONObject;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class Medicine {

    /**
     * 공공데이터포털 OPEN API 식품의약품안전처_의약품 낱알식별 정보 사용
     */

    /**
     * 품목기준코드
     */
    @Id
    private String itemCode;

    /**
     * 전문성
     */
    @Column
    private String professionalism;

    /**
     * 제품명_한글
     */
    @Column
    private String itemNameKor;

    /**
     * 제품명_영문
     */
    @Column
    private String itemNameEng;

    @Builder
    public Medicine(String itemCode, String professionalism, String itemNameKor, String itemNameEng) {
        this.itemCode = itemCode;
        this.professionalism = professionalism;
        this.itemNameKor = itemNameKor;
        this.itemNameEng = itemNameEng;
    }

    public static Medicine jsonToEntity(JSONObject jsonObject) {
        return Medicine.builder()
                .itemCode(jsonObject.optString("ITEM_SEQ"))
                .professionalism(jsonObject.optString("ETC_OTC_NAME"))
                .itemNameKor(jsonObject.optString("ITEM_NAME"))
                .itemNameEng(jsonObject.optString("ITEM_ENG_NAME")).build();
    }
}
