package com.smiley.smileybackend.dto.response.dtolist;

import com.smiley.smileybackend.dto.response.MagazineInfoDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MagazineInfoDtoList {
    List<MagazineInfoDto> magazineInfoDtos;

    @Builder
    public MagazineInfoDtoList(List<MagazineInfoDto> magazineInfoDtos) {
        this.magazineInfoDtos = magazineInfoDtos;
    }
}
