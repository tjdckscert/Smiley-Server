package com.smiley.smileybackend._04_userState.service;

import com.smiley.smileybackend._03_dailyWearTime.domain.DailyWearTime;
import com.smiley.smileybackend._04_userState.dto.TestDateDto;
import com.smiley.smileybackend._04_userState.dto.UserSpecificDateWearTimeDto;
import com.smiley.smileybackend._01_user.dto.user.SpecificDateWearTimeDto;
import com.smiley.smileybackend._03_dailyWearTime.repository.DailyWearTimeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserStateService {

    private final DailyWearTimeRepository dailyWearTimeRepository;

    public UserStateService(DailyWearTimeRepository dailyWearTimeRepository) {
        this.dailyWearTimeRepository = dailyWearTimeRepository;
    }

    public UserSpecificDateWearTimeDto getAnyDayWearTime(SpecificDateWearTimeDto specificDateWearTimeDto) {
        DailyWearTime dailyWearTime = dailyWearTimeRepository.
                findByUserUserNumberAndWearDate(specificDateWearTimeDto.getUserNumber(), specificDateWearTimeDto.getWearDate());
        return new UserSpecificDateWearTimeDto(dailyWearTime);
    }

    public TestDateDto getTodayInfor(String day) {
        return new TestDateDto();
    }
}
