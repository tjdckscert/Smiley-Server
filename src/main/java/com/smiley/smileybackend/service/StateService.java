package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.DailyWearTime;
import com.smiley.smileybackend.dto.response.TestDateDto;
import com.smiley.smileybackend.dto.response.UserSpecificDateWearTimeDto;
import com.smiley.smileybackend.dto.user.SpecificDateWearTimeDto;
import com.smiley.smileybackend.repository.DailyWearTimeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StateService {

    private final DailyWearTimeRepository dailyWearTimeRepository;

    public StateService(DailyWearTimeRepository dailyWearTimeRepository) {
        this.dailyWearTimeRepository = dailyWearTimeRepository;
    }

    public UserSpecificDateWearTimeDto getAnyDayWearTime(SpecificDateWearTimeDto specificDateWearTimeDto) {
        DailyWearTime dailyWearTime = dailyWearTimeRepository.
                findByUserIdAndWearDate(specificDateWearTimeDto.getUserId(), specificDateWearTimeDto.getWearDate());
        return new UserSpecificDateWearTimeDto(dailyWearTime);
    }

    public TestDateDto getTodayInfor(String day) {
        return new TestDateDto();
    }
}
