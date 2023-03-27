package com.smiley.smileybackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class Medicine {
    /*
     *식품의약품안전처 묶음의약품정보서비스 API 사용
     */

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String name;

    /*대표 품목기준코드*/
    @Column(length = 200)
    private String trustIndutyCode;

    /*대표 제품명*/
    @Column(length = 200)
    private String trustItemName;

    /*대표 주성분*/
    @Column(length = 200)
    private String trustMainingr;

    /*대표 함량*/
    @Column(length = 200)
    private String trustQntList;

    /*대표 업소명*/
    @Column(length = 200)
    private String trustEntpName;

    /*대표 제조소*/
    @Column(length = 200)
    private String trustManuf;

    /*대표 허가일자*/
    @Column(length = 200)
    private String trustItemPermitDate;

    /*대표 심평원주성분코드*/
    @Column(length = 200)
    private String trustHiraMainingrCode;

    /*대표 심평원제품코드*/
    @Column(length = 200)
    private String trustHiraPrductCode;

    /*대표 ATC코드*/
    @Column(length = 200)
    private String trustAtcCode;

    /*취소/취하명*/
    @Column(length = 200)
    private String trustCancelName;

    /*품목기준코드*/
    @Column(length = 200)
    private String cnsgnItemSeq;

    /*제품명*/
    @Column(length = 200)
    private String cnsgnItemName;

    /*업소명*/
    @Column(length = 200)
    private String cnsgnEntpName;

    /*제조소*/
    @Column(length = 200)
    private String cnsgnManuf;

    /*허가일자*/
    @Column(length = 200)
    private String cnsgnItemPermitDate;

    /*심평원제품코드*/
    @Column(length = 200)
    private String cnsgnHiraPrductCode;

    /*취소/취하명*/
    @Column(length = 200)
    private String cnsgnCancelName;

    @Builder
    public Medicine(Integer id, String name, String trustIndutyCode, String trustItemName, String trustMainingr, String trustQntList, String trustEntpName, String trustManuf, String trustItemPermitDate, String trustHiraMainingrCode, String trustHiraPrductCode, String trustAtcCode, String trustCancelName, String cnsgnItemSeq, String cnsgnItemName, String cnsgnEntpName, String cnsgnManuf, String cnsgnItemPermitDate, String cnsgnHiraPrductCode, String cnsgnCancelName) {
        this.id = id;
        this.name = name;
        this.trustIndutyCode = trustIndutyCode;
        this.trustItemName = trustItemName;
        this.trustMainingr = trustMainingr;
        this.trustQntList = trustQntList;
        this.trustEntpName = trustEntpName;
        this.trustManuf = trustManuf;
        this.trustItemPermitDate = trustItemPermitDate;
        this.trustHiraMainingrCode = trustHiraMainingrCode;
        this.trustHiraPrductCode = trustHiraPrductCode;
        this.trustAtcCode = trustAtcCode;
        this.trustCancelName = trustCancelName;
        this.cnsgnItemSeq = cnsgnItemSeq;
        this.cnsgnItemName = cnsgnItemName;
        this.cnsgnEntpName = cnsgnEntpName;
        this.cnsgnManuf = cnsgnManuf;
        this.cnsgnItemPermitDate = cnsgnItemPermitDate;
        this.cnsgnHiraPrductCode = cnsgnHiraPrductCode;
        this.cnsgnCancelName = cnsgnCancelName;
    }
}
