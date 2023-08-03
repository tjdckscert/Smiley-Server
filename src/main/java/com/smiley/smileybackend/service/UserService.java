package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.domain.UserMedicalInfo;
import com.smiley.smileybackend.dto.response.UserInfoAndMedicalInfoDto;
import com.smiley.smileybackend.dto.response.UserInfoDto;
import com.smiley.smileybackend.dto.user.UserInfoUpdateDto;
import com.smiley.smileybackend.dto.user.UserLoginDto;
import com.smiley.smileybackend.exception.ErrorCode;
import com.smiley.smileybackend.exception.ErrorException;
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

    /**
     * 로그인
     *
     * @author : 김성찬
     * @param : 사용자 고유 번호
     * @return : 사용자 정보
     * @throws : 사용자 고유 번호 존재 하지 않으면 NEW_USER
     */
    public UserInfoDto login(@Valid String userNumber) {
        Optional<User> user = userRepository.findByUserNumber(userNumber);
        if (user.isEmpty()){
            throw new ErrorException(ErrorCode.NEW_USER);
        }
        return new UserInfoDto(user.get());
    }

    /**
     * 회원가입
     *
     * @author : 김성찬
     * @param : 회원 가입 정보를 담은 UserLoginDto Class
     * @return : 사용자 정보
     */
    public UserInfoDto signUp(@Valid UserLoginDto userLoginDto) {
        User newUser = userRepository.save(userLoginDto.toEntity());
        return new UserInfoDto(newUser);
    }

    public UserInfoDto signUptest(@Valid UserLoginDto userLoginDto) {
        Optional<User> user = userRepository.findByUserNumber(userLoginDto.getUserNumber());
        if (user.isEmpty()){
            userRepository.save(userLoginDto.toEntity());
            return new UserInfoDto();
        }
        return new UserInfoDto(user.get());
    }

    /**
     * 사용자 정보 및 의료정보를 입력받아 의료정보는 저장하고 사용자 정보는 이미 존재하는 사용자는 업데이트하고 존재하지 않는 사용자는 저장한다.
     *
     * @author : 김성찬
     * @param : 사용자 정보를 담은 UserInfoUpdateDto Class
     * @return : 사용자 정보 및 의료 정보
     */
    public UserInfoAndMedicalInfoDto saveuserinfos(UserInfoUpdateDto userInfoUpdateDto) {
        Optional<User> user = userRepository.findByUserNumber(userInfoUpdateDto.getUserNumber());
        //존재하지 않는 사용자인경우 추가
        if (user.isEmpty()){
            user = Optional.of(userRepository.save(userInfoUpdateDto.toUserEntity()));
            userInfoUpdateDto.setUserNumber(user.get().getUserNumber());
        }
        else{
        //존재하는 사용자인경우 업데이트
            userInfoUpdateDto.setUserNumber(user.get().getUserNumber());
            User user1 = userInfoUpdateDto.toUserEntity();
            user1.setUserNumber(user.get().getUserNumber());
            userRepository.save(user1);
        }
        //의료정보는 어차피 여러개 저장할 수 있으니까 그냥 저장
        UserMedicalInfo userMedicalInfo = userMedicalInfoRepository.save(userInfoUpdateDto.toUserMedicalInfoEntity(getUser(userInfoUpdateDto.getUserNumber()), getHospital(userInfoUpdateDto.getHPId())));
        return new UserInfoAndMedicalInfoDto(userInfoUpdateDto);
    }

    /**
     * DB에서 사용자 정보를 가져온다
     *
     * @author : 김성찬
     * @param : 사용자 Index
     * @return : 사용자 정보
     * @throws : 사용자 Index가 존재 하지 않으면 HOSPITAL_NOT_FOUND
     */
    public User getUser(String userNumber){
        return userRepository.findById(userNumber).orElseThrow(
                () -> new ErrorException(ErrorCode.USER_NOT_FOUND)
        );
    }

    /**
     * DB에서 병원 정보를 가져온다
     *
     * @author : 김성찬
     * @param : 병원 고유 ID
     * @return : 병원 정보
     * @throws : 병원 ID가 존재 하지 않으면 HOSPITAL_NOT_FOUND
     */
    public Hospital getHospital(String hPid){
        return hospitalRepository.findByHPid(hPid).orElseThrow(
                () -> new ErrorException(ErrorCode.HOSPITAL_NOT_FOUND)
        );
    }

}
