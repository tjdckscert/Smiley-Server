package com.smiley.smileybackend.domain;

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
     * 제품명_영문
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
    private String itemDescription;

}
