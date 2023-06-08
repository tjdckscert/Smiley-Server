package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.DailyWearTime;
import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.dto.response.DailyWearTimeInfoDto;
import com.smiley.smileybackend.dto.response.LastSevenDaysWearTimeDto;
import com.smiley.smileybackend.dto.response.TestDateDto;
import com.smiley.smileybackend.dto.response.UserSpecificDateWearTimeDto;
import com.smiley.smileybackend.dto.response.dtolist.LastSevenDaysWearTimeDtoList;
import com.smiley.smileybackend.dto.user.SpecificDateWearTimeDto;
import com.smiley.smileybackend.dto.user.DailyWearTimeDto;
import com.smiley.smileybackend.exception.ErrorCode;
import com.smiley.smileybackend.exception.ErrorException;
import com.smiley.smileybackend.repository.DailyWearTimeRepository;
import com.smiley.smileybackend.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

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
                () -> new ErrorException(ErrorCode.USER_NOT_FOUND)
        );
        DailyWearTime dailyWearTime = dailyWearTimeRepository.save(dailyWearTimeDto.toEntity(user));
        return new DailyWearTimeInfoDto(dailyWearTime);
    }

    public LastSevenDaysWearTimeDtoList getLastSevenDayWearTime(Integer id) {
        Pageable pageable = PageRequest.of(0,7);
        return new LastSevenDaysWearTimeDtoList(dailyWearTimeRepository.findByUserIdOrderByIdDesc(id, pageable)
                .stream()
                .map(LastSevenDaysWearTimeDto::entityToDto)
                .collect(Collectors.toList()));

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
