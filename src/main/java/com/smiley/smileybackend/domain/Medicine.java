package com.smiley.smileybackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class Medicine {

    /**
     * 국립중앙의료원 국립중앙의료원 전국 병·의원 찾기 서비스 API 사용
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 제품명
     * */
    @Column
    private String itemName;

    /**
     * 전문성
     * */
    @Column
    private String professionalism;

    /**
     * 품목기준코드
     * */
    @Column
    private String itemCode;

    /**
     * 주성분
     * */
    @Column
    private String mainIngredient;

    @Builder
    public Medicine(Integer id, String itemName, String professionalism, String itemCode, String mainIngredient) {
        this.id = id;
        this.itemName = itemName;
        this.professionalism = professionalism;
        this.itemCode = itemCode;
        this.mainIngredient = mainIngredient;
    }


}
