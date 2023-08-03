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

    /**
     * 일일 착용 경험치를 저장한다
     *
     * @author : 김성찬
     * @param : 일일 착용 시간 및 날짜등이 담긴 DailyWearTimeDto Class
     * @return : 저장한 정보 반환
     */
    public DailyExpStasticsInfoDto saveExp(DailyWearTimeDto dailyWearTimeDto) {
        User user  = userRepository.findById(dailyWearTimeDto.getUserNumber()).orElseThrow(
                () -> new ErrorException(ErrorCode.USER_NOT_FOUND)
        );
        List<ExpJsonDto> dailyExp = new ArrayList<>();
        dailyExp.add(new ExpJsonDto("일일 착용 경험치",dailyWearTimeDto.getTotalWearTime()*10));
        DailyExpStastics dailyExpStastics = dailyExpStasticsRepository.findByUserUserNumberAndDate(dailyWearTimeDto.getUserNumber(),dailyWearTimeDto.getWearDate()).orElse(
                dailyWearTimeDto.toDailyExpEntity(user)
        );
        if (dailyExpStastics.getExpStastics() != null) {
            dailyExp.addAll(dailyExpStastics.getExpStastics());
        }
        dailyExpStastics.setExpStastics(dailyExp);
        dailyExpStasticsRepository.save(dailyExpStastics);
        return new DailyExpStasticsInfoDto (dailyExpStastics);
    }
}
