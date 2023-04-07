package com.smiley.smileybackend.dto.response.dtolist;

import com.smiley.smileybackend.dto.response.MedicineInfoDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MedicineInfoDtoList {
    List<MedicineInfoDto> medicines;

    @Builder
    public MedicineInfoDtoList(List<MedicineInfoDto> medicines) {
        this.medicines = medicines;
    }
}
