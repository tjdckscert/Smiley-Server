package com.smiley.smileybackend.drug.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class Drug {

    /**
     * 의약품안전나라(https://nedrug.mfds.go.kr/searchDrug)에서 제공하는 의약품 제품 정보 엑셀 파일 사용
     */

    /**
     * 품목기준코드
     */
    @Id
    private String itemCode;

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

    /**
     * 주성문_한글
     */
    @Column(columnDefinition = "TEXT")
    private String itemSubstanceKor;

    /**
     * 주성문_영문
     */
    @Column(columnDefinition = "TEXT")
    private String itemSubstanceEng;

    /**
     * 전문성
     */
    @Column
    private String professionalism;

    @Column
    private boolean isSafeForConsumption;


    @Builder
    public Drug(String itemCode, String itemNameKor, String itemNameEng, String itemSubstanceKor, String itemSubstanceEng, String professionalism, boolean isSafeForConsumption) {
        this.itemCode = itemCode;
        this.itemNameKor = itemNameKor;
        this.itemNameEng = itemNameEng;
        this.itemSubstanceKor = itemSubstanceKor;
        this.itemSubstanceEng = itemSubstanceEng;
        this.professionalism = professionalism;
        this.isSafeForConsumption = isSafeForConsumption;

    }

}
