package com.smiley.smileybackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Medicine {
    /**
     * 식품의약품안전처_의약품개요정보(e약은요) API 사용
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 업체명
     * */
    @Column
    private String entpName;

    /**
     * 제품명
     * */
    @Column
    private String itemName;

    /**
     * 품목기준코드
     * */
    @Column
    private String itemSeq;

    /**
     * 문항1(효능)
     * */
    @Column
    private String efcyQesitm;

    /**
     * 문항2(사용법)
     * */
    @Column
    private String useMethodQesitm;

    /**
     * 문항3(주의사항경고)
     * */
    @Column
    private String atpnWarnQesitm;

    /**
     * 문항4(주의사항)
     * */
    @Column
    private String atpnQesitm;


    /**
     * 문항5(상호작용)
     * */
    @Column
    private String intrcQesitm;

    /**
     * 문항6(부작용)
     * */
    @Column
    private String seQesitm;

    /**
     * 문항7(보관법)
     * */
    @Column
    private String depositMethodQesitm;

    /**
     * 공개일자
     * */
    @Column
    private String openDe;

    /**
     * 수정일자
     * */
    @Column
    private String updateDe;

    /**
     * 낱알이미지
     * */
    @Column
    private String itemImage;

    @Builder
    public Medicine(Integer id, String entpName, String itemName, String itemSeq, String efcyQesitm, String useMethodQesitm, String atpnWarnQesitm, String atpnQesitm, String intrcQesitm, String seQesitm, String depositMethodQesitm, String openDe, String updateDe, String itemImage) {
        this.id = id;
        this.entpName = entpName;
        this.itemName = itemName;
        this.itemSeq = itemSeq;
        this.efcyQesitm = efcyQesitm;
        this.useMethodQesitm = useMethodQesitm;
        this.atpnWarnQesitm = atpnWarnQesitm;
        this.atpnQesitm = atpnQesitm;
        this.intrcQesitm = intrcQesitm;
        this.seQesitm = seQesitm;
        this.depositMethodQesitm = depositMethodQesitm;
        this.openDe = openDe;
        this.updateDe = updateDe;
        this.itemImage = itemImage;
    }
}
