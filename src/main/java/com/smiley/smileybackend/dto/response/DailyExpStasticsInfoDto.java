package com.smiley.smileybackend.dto.response;


import com.smiley.smileybackend.domain.DailyExpStastics;
import com.smiley.smileybackend.dto.user.ExpJsonDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@Setter
public class DailyExpStasticsInfoDto {

    private Integer id;

    private Integer userId;

    private LocalDate date;

    private List<ExpJsonDto> expStastics;

    public DailyExpStasticsInfoDto(DailyExpStastics saved) {
        this.id = saved.getId();
        this.userId=saved.getId();
        this.date = saved.getDate();
        this.expStastics=saved.getExpStastics();
    }

    @Builder
    public DailyExpStasticsInfoDto(Integer id, Integer userId, LocalDate date, List<ExpJsonDto> expStastics) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.expStastics = expStastics;
    }
}
