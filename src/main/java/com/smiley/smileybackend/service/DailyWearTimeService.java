package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.DailyWearTime;
import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.dto.response.DailyWearTimeInfoDto;
import com.smiley.smileybackend.dto.user.DailyWearTimeDto;
import com.smiley.smileybackend.repository.DailyWearTimeRepository;
import com.smiley.smileybackend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DailyWearTimeService {
    private final DailyWearTimeRepository dailyWearTimeRepository;
    private final UserRepository userRepository;

    public DailyWearTimeService(DailyWearTimeRepository dailyWearTimeRepository, UserRepository userRepository) {
        this.dailyWearTimeRepository = dailyWearTimeRepository;
        this.userRepository = userRepository;
    }

    public DailyWearTimeInfoDto saveWearTime(DailyWearTimeDto dailyWearTimeDto) {
        User user  = userRepository.findById(dailyWearTimeDto.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없습니다")
        );
        DailyWearTime dailyWearTime = dailyWearTimeRepository.save(dailyWearTimeDto.toEntity(user));
        return new DailyWearTimeInfoDto(dailyWearTime);
    }
}
