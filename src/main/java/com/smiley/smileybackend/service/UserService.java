package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.domain.UserMedicalInfo;
import com.smiley.smileybackend.dto.response.UserInfoAndMedicalInfoDto;
import com.smiley.smileybackend.dto.response.UserInfoDto;
import com.smiley.smileybackend.dto.user.UserInfoUpdateDto;
import com.smiley.smileybackend.dto.user.UserLoginDto;
import com.smiley.smileybackend.repository.HospitalRepository;
import com.smiley.smileybackend.repository.UserMedicalInfoRepository;
import com.smiley.smileybackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    private final HospitalRepository hospitalRepository;

    private final UserMedicalInfoRepository userMedicalInfoRepository;

    public UserService(UserRepository userRepository, HospitalRepository hospitalRepository, UserMedicalInfoRepository userMedicalInfoRepository) {
        this.userRepository = userRepository;
        this.hospitalRepository = hospitalRepository;
        this.userMedicalInfoRepository = userMedicalInfoRepository;
    }


    public UserInfoDto signUp(@Valid UserLoginDto userLoginDto) {
        Optional<User> user = userRepository.findByUserNumber(userLoginDto.getUserNumber());
        if (user.isEmpty()){
            userRepository.save(userLoginDto.toEntity());
            return new UserInfoDto();
        }
        return new UserInfoDto(user.get());
    }

    /**사용자 정보 및 의료정보를 입력받아 의료정보는 저장하고 사용자 정보는 이미 존재하는 사용자는 업데이트하고 존재하지 않는 사용자는 저장한다.
     **/
    public UserInfoAndMedicalInfoDto saveuserinfos(UserInfoUpdateDto userInfoUpdateDto) {
        Optional<User> user = userRepository.findByUserNumber(userInfoUpdateDto.getUserNumber());
        //존재하지 않는 사용자인경우 추가
        if (user.isEmpty()){
            user = Optional.of(userRepository.save(userInfoUpdateDto.toUserEntity()));
            userInfoUpdateDto.setId(user.get().getId());
        }
        else{
        //존재하는 사용자인경우 업데이트
            userInfoUpdateDto.setId(user.get().getId());
            User user1 = userInfoUpdateDto.toUserEntity();
            user1.setId(user.get().getId());
            userRepository.save(user1);
        }
        //의료정보는 어차피 여러개 저장할 수 있으니까 그냥 저장
        UserMedicalInfo userMedicalInfo = userMedicalInfoRepository.save(userInfoUpdateDto.toUserMedicalInfoEntity(getUser(userInfoUpdateDto.getId()), getHospital(userInfoUpdateDto.getHospitalhPid())));
        return new UserInfoAndMedicalInfoDto(userInfoUpdateDto);
    }

    public User getUser(Integer id){
        return userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없습니다")
        );
    }

    /**사용자의 ID로 부터 정보를 가져온다.
     * */
    public Hospital getHospital(String hPid){
        return hospitalRepository.findByHPid(hPid).orElseThrow(
                () -> new IllegalArgumentException("병원을 찾을 수 없습니다")
        );
    }

}
