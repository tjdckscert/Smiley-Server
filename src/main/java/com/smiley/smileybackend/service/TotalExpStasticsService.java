package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.TotalExpStastics;
import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.dto.response.TotalExpStasticsInfoDto;
import com.smiley.smileybackend.dto.user.DailyWearTimeDto;
import com.smiley.smileybackend.dto.user.ExpJsonDto;
import com.smiley.smileybackend.exception.ErrorCode;
import com.smiley.smileybackend.exception.ErrorException;
import com.smiley.smileybackend.repository.TierRepositoory;
import com.smiley.smileybackend.repository.TotalExpStasticsRepository;
import com.smiley.smileybackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TotalExpStasticsService {
    private final TotalExpStasticsRepository totalExpStasticsRepository;
    private final UserRepository userRepository;
    private final TierRepositoory tierRepositoory;

    public TotalExpStasticsService(TotalExpStasticsRepository totalExpStasticsRepository, UserRepository userRepository, TierRepositoory tierRepositoory) {
        this.totalExpStasticsRepository = totalExpStasticsRepository;
        this.userRepository = userRepository;
        this.tierRepositoory = tierRepositoory;
    }

    /**
     * 일일 총 경험치량 저장
     *
     * @author : 김성찬
     * @param : 일일 착용 정보를 가지고 있는 DailyWearTimeDto Class
     * @return : 저장된 총 경험치량
     * @throws : 사용자 Index가 존재 하지 않으면 HOSPITAL_NOT_FOUND
     */
    public TotalExpStasticsInfoDto saveTotalExp(DailyWearTimeDto dailyWearTimeDto) {
        User user = userRepository.findById(dailyWearTimeDto.getUserNumber()).orElseThrow(
                ()-> new ErrorException(ErrorCode.USER_NOT_FOUND)
        );
        List<ExpJsonDto> totalExps = new ArrayList<>();
        totalExps.add(new ExpJsonDto("일일 착용 경험치",dailyWearTimeDto.getTotalWearTime()*10));
        TotalExpStastics totalExpStastics= totalExpStasticsRepository.findById(dailyWearTimeDto.getTotalWearTime()).orElse(
                new TotalExpStastics(null,dailyWearTimeDto.getTotalWearTime()*10,null, "BRONZE",user)
        );
        if (totalExpStastics.getTotalExpStastics() != null) {
            totalExps.addAll(totalExpStastics.getTotalExpStastics());
            totalExpStastics.setTotalExp(totalExpStastics.getTotalExp()+dailyWearTimeDto.getTotalWearTime()*10);
        }
        totalExpStastics.setTotalExpStastics(totalExps);
        totalExpStasticsRepository.save(totalExpStastics);
        return new TotalExpStasticsInfoDto(totalExpStastics);
    }
    public String getTire(Integer exp){
        return tierRepositoory.findByExpStartAfterBefore(exp).toString();
    }
}
