package com.smiley.smileybackend._07_drug.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class ContraindicatedDrug {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 성분명_한글
     */
    @Column
    private String itemNameKor;

    /**
     * 성분명_영문
     */
    @Column
    private String itemNameEng;

    /**
     * 설명
     */
    @Column(columnDefinition = "TEXT")
    private String itemDescription;


    @Builder
    public ContraindicatedDrug(String itemNameKor, String itemNameEng, String itemDescription) {
        this.itemNameKor = itemNameKor;
        this.itemNameEng = itemNameEng;
        this.itemDescription = itemDescription;


    }

}
