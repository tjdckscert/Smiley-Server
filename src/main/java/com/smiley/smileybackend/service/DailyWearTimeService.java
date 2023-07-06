package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.DailyWearTime;
import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.dto.response.DailyWearTimeInfoDto;
import com.smiley.smileybackend.dto.response.LastSevenDaysWearTimeDto;
import com.smiley.smileybackend.dto.response.dtolist.LastSevenDaysWearTimeDtoList;
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

    /**
     * 일일 착용 시간 저장
     *
     * @author : 김성찬
     * @param : 착용 시간,착용 날짜등이 담긴 DailyWearTimeDto Class
     * @return :
     */
    public DailyWearTimeInfoDto saveWearTime(DailyWearTimeDto dailyWearTimeDto) {
        User user  = userRepository.findById(dailyWearTimeDto.getUserId()).orElseThrow(
                () -> new ErrorException(ErrorCode.USER_NOT_FOUND)
        );
        DailyWearTime dailyWearTime = dailyWearTimeRepository.save(dailyWearTimeDto.toEntity(user));
        return new DailyWearTimeInfoDto(dailyWearTime);
    }

    /**
     * 최근 7일 착용 시간 정보 가져오기
     *
     * @author : 김성찬
     * @param : 사용자 Index
     * @return : 사용자 7일 착용 시간 정보
     */
    public LastSevenDaysWearTimeDtoList getLastSevenDayWearTime(Integer id) {
        Pageable pageable = PageRequest.of(0,7);
        return new LastSevenDaysWearTimeDtoList(dailyWearTimeRepository.findByUserIdOrderByIdDesc(id, pageable)
                .stream()
                .map(LastSevenDaysWearTimeDto::entityToDto)
                .collect(Collectors.toList()));

    }

}
