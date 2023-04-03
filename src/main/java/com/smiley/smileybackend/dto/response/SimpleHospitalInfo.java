package com.smiley.smileybackend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class SimpleHospitalInfo {
    private Integer id;
    private String name;
    private String dutyAddr;

    @Builder
    public SimpleHospitalInfo(Integer id, String name, String dutyAddr){
        this.id =id;
        this.name = name;
        this.dutyAddr=dutyAddr;
    }
}
