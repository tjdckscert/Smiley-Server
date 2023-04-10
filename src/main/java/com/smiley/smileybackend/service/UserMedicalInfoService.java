package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.domain.UserMedicalInfo;
import com.smiley.smileybackend.dto.response.UserMedicalInfoDto;
import com.smiley.smileybackend.dto.user.MedicalInfoDto;
import com.smiley.smileybackend.repository.HospitalRepository;
import com.smiley.smileybackend.repository.UserMedicalInfoRepository;
import com.smiley.smileybackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserMedicalInfoService {

    private UserMedicalInfoRepository userMedicalInfoRepository;

    private UserRepository userRepository;

    private HospitalRepository hospitalRepository;

    public UserMedicalInfoService(UserMedicalInfoRepository userMedicalInfoRepository,UserRepository userRepository, HospitalRepository hospitalRepository){
        this.userRepository=userRepository;
        this.userMedicalInfoRepository=userMedicalInfoRepository;
        this.hospitalRepository=hospitalRepository;
    }

    /**사용자의 ID 와 병원 ID를 가져와서 검색 후 사용자의 의료정보와 함께 UserMedicalInfo에 등록한다.
     * */
    public UserMedicalInfoDto savemedicalinfo(MedicalInfoDto medicalInfoDto) {
        UserMedicalInfo userMedicalInfo = userMedicalInfoRepository.save(medicalInfoDto.toEntity(getUser(medicalInfoDto.getUserId()), getHospital(medicalInfoDto.getHospitalhPid())));
        return new UserMedicalInfoDto(userMedicalInfo);
    }

    /**사용자의 ID로 부터 정보를 사져온다.
     * */
    public User getUser(Integer id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없습니다")
        );
        return user;
    }

    /**사용자의 ID로 부터 정보를 사져온다.
     * */
    public Hospital getHospital(String hPid){
        Hospital hospital = hospitalRepository.findByHPid(hPid).orElseThrow(
                () -> new IllegalArgumentException("병원을 찾을 수 없습니다")
        );
        return hospital;
    }
}
