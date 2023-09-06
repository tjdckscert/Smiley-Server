package com.smiley.smileybackend._08_magazine.dto;

import com.smiley.smileybackend._08_magazine.dto.MagazineInfoDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MagazineInfoDtoList {
    List<MagazineInfoDto> magazines;

    @Builder
    public MagazineInfoDtoList(List<MagazineInfoDto> magazines) {
        this.magazines = magazines;
    }
}
