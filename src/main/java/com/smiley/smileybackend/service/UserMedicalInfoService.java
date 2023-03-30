package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.domain.UserMedicalInfo;
import com.smiley.smileybackend.dto.response.UserMedicalInfoSave;
import com.smiley.smileybackend.dto.user.MedicalInfo;
import com.smiley.smileybackend.repository.HospitalRepository;
import com.smiley.smileybackend.repository.UserMedicalInfoRepository;
import com.smiley.smileybackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserMedicalInfoService {
    @Autowired
    private UserMedicalInfoRepository userMedicalInfoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    /**사용자의 ID 와 병원 ID를 가져와서 검색 후 사용자의 의료정보와 함께 UserMedicalInfo에 등록한다.
     * */
    public UserMedicalInfoSave savemedicalinfo(MedicalInfo medicalInfo) {
        UserMedicalInfo userMedicalInfo = userMedicalInfoRepository.save(medicalInfo.toEntity(getUser(medicalInfo.getUser_id()), getHospital(medicalInfo.getHospital_id())));
        return new UserMedicalInfoSave(userMedicalInfo);
    }

    /**사용자의 ID로 부터 정보를 사져온다.
     * */
    public User getUser(Integer id){
        User user = userRepository.findById(id).orElseThrow(
//                () -> new BadRequestException("존재하지 않는 사용자 입니다.") 추후에 Exception 추가할 예정
        );
        return user;
    }

    /**사용자의 ID로 부터 정보를 사져온다.
     * */
    public Hospital getHospital(long id){
        Hospital hospital = hospitalRepository.findByHospitalId(id).orElseThrow(
//                () -> new BadRequestException("존재하지 않는 병원 입니다.")추후에 Exception 추가할 예정
        );
        return hospital;
    }
}
