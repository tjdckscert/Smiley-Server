package com.smiley.smileybackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(length = 200)
    private String trustIndutyCode;

    @Column(length = 200)
    private String trustItemName;

    @Column(length = 200)
    private String trustMainingr;

    @Column(length = 200)
    private String trustQntList;

    @Column(length = 200)
    private String trustEntpName;

    @Column(length = 200)
    private String trustManuf;

    @Column(length = 200)
    private String trustItemPermitDate;

    @Column(length = 200)
    private String trustHiraMainingrCode;

    @Column(length = 200)
    private String trustHiraPrductCode;

    @Column(length = 200)
    private String trustAtcCode;

    @Column(length = 200)
    private String trustCancelName;

    @Column(length = 200)
    private String cnsgnItemSeq;

    @Column(length = 200)
    private String cnsgnItemName;

    @Column(length = 200)
    private String cnsgnEntpName;

    @Column(length = 200)
    private String cnsgnManuf;

    @Column(length = 200)
    private String cnsgnItemPermitDate;

    @Column(length = 200)
    private String cnsgnHiraPrductCode;

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
