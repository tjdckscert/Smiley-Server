package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.DailyExpStastics;
import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.dto.response.DailyExpStasticsInfoDto;
import com.smiley.smileybackend.dto.user.DailyWearTimeDto;
import com.smiley.smileybackend.dto.user.ExpJsonDto;
import com.smiley.smileybackend.exception.ErrorCode;
import com.smiley.smileybackend.exception.ErrorException;
import com.smiley.smileybackend.repository.DailyExpStasticsRepository;
import com.smiley.smileybackend.repository.UserRepository;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@ToString
@Getter
public class DailyExpStasticsService {
    private final DailyExpStasticsRepository dailyExpStasticsRepository;

    private final UserRepository userRepository;

    public DailyExpStasticsService(DailyExpStasticsRepository dailyExpStasticsRepository, UserRepository userRepository) {
        this.dailyExpStasticsRepository = dailyExpStasticsRepository;
        this.userRepository = userRepository;
    }

    public DailyExpStasticsInfoDto saveExp(DailyWearTimeDto dailyWearTimeDto) {
        User user  = userRepository.findById(dailyWearTimeDto.getUserId()).orElseThrow(
                () -> new ErrorException(ErrorCode.USER_NOT_FOUND)
        );
        List<ExpJsonDto> todayExps = new ArrayList<>();
        todayExps.add(new ExpJsonDto("일일 착용 경험치",dailyWearTimeDto.getTotalWearTime()*10));
        DailyExpStastics dailyExpStastics = dailyExpStasticsRepository.findByUser_IdAndDate(dailyWearTimeDto.getUserId(),dailyWearTimeDto.getWearDate()).orElse(
                dailyWearTimeDto.toDailyExpEntity(user)
        );
        if (dailyExpStastics.getExpStastics() != null) {
            todayExps.addAll(dailyExpStastics.getExpStastics());
        }
        dailyExpStastics.setExpStastics(todayExps);
        dailyExpStasticsRepository.save(dailyExpStastics);
        return new DailyExpStasticsInfoDto (dailyExpStastics);
    }
}
