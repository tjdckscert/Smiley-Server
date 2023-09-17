package com.smiley.smileybackend._07_drug.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class DrugInfoDtoList {
    List<DrugInfoDto> drugs;

    @Builder
    public DrugInfoDtoList(List<DrugInfoDto> drugs) {
        this.drugs = drugs;
    }
}
