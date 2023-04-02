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

    private String name;

    /*대표 품목기준코드*/
    private String trustIndutyCode;

    /*대표 제품명*/
    private String trustItemName;

    /*대표 주성분*/
    private String trustMainingr;

    /*대표 함량*/
    private String trustQntList;

    /*대표 업소명*/
    private String trustEntpName;

    /*대표 제조소*/
    private String trustManuf;

    /*대표 허가일자*/
    private String trustItemPermitDate;

    /*대표 심평원주성분코드*/
    private String trustHiraMainingrCode;

    /*대표 심평원제품코드*/
    private String trustHiraPrductCode;

    /*대표 ATC코드*/
    private String trustAtcCode;

    /*취소/취하명*/
    private String trustCancelName;

    /*품목기준코드*/
    private String cnsgnItemSeq;

    /*제품명*/
    private String cnsgnItemName;

    /*업소명*/
    private String cnsgnEntpName;

    /*제조소*/
    private String cnsgnManuf;

    /*허가일자*/
    private String cnsgnItemPermitDate;

    /*심평원제품코드*/
    private String cnsgnHiraPrductCode;

    /*취소/취하명*/
    private String cnsgnCancelName;

    public MedicineInfoDto(Medicine saved) {
        this.id = saved.getId();
        this.name = saved.getName();
        this.trustIndutyCode = saved.getTrustIndutyCode();
        this.trustItemName = saved.getTrustItemName();
        this.trustMainingr = saved.getTrustMainingr();
        this.trustQntList = saved.getTrustQntList();
        this.trustEntpName = saved.getTrustEntpName();
        this.trustManuf = saved.getTrustManuf();
        this.trustItemPermitDate = saved.getTrustItemPermitDate();
        this.trustHiraMainingrCode = saved.getTrustHiraMainingrCode();
        this.trustHiraPrductCode = saved.getTrustHiraPrductCode();
        this.trustAtcCode = saved.getTrustAtcCode();
        this.trustCancelName = saved.getTrustCancelName();
        this.cnsgnItemSeq = saved.getCnsgnItemSeq();
        this.cnsgnItemName = saved.getCnsgnItemName();
        this.cnsgnEntpName = saved.getCnsgnEntpName();
        this.cnsgnManuf = saved.getCnsgnManuf();
        this.cnsgnItemPermitDate = saved.getCnsgnItemPermitDate();
        this.cnsgnHiraPrductCode = saved.getCnsgnHiraPrductCode();
        this.cnsgnCancelName = saved.getCnsgnCancelName();
    }
}
