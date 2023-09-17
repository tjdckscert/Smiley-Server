package com.smiley.smileybackend._03_dailyWearTime.dto;

import com.smiley.smileybackend._01_user.domain.TotalExpStastics;
import com.smiley.smileybackend._01_user.dto.user.ExpJsonDto;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
@Setter
public class TotalExpStasticsInfoDto {

    private Integer id;

    private String userNumber;

    private Integer totalExp;

    private List<ExpJsonDto> totalExpStastics;

    private String userTier;

    @Builder
    public TotalExpStasticsInfoDto(Integer id, String userNumber, Integer totalExp, List<ExpJsonDto> totalExpStastics, String userTier) {
        this.id = id;
        this.userNumber = userNumber;
        this.totalExp = totalExp;
        this.totalExpStastics = totalExpStastics;
        this.userTier = userTier;
    }

    public TotalExpStasticsInfoDto(TotalExpStastics saved) {
        this.id= saved.getId();
        this.userNumber=saved.getUser().getUserNumber();
        this.totalExp=saved.getTotalExp();
        this.totalExpStastics=saved.getTotalExpStastics();
        this.userTier=saved.getUserTier();
    }
}
