package com.smiley.smileybackend._02_userDevice.service;

import com.smiley.smileybackend._01_user.domain.User;
import com.smiley.smileybackend._02_userDevice.domain.UserDevice;
import com.smiley.smileybackend._02_userDevice.dto.UserDeviceInfoDto;
import com.smiley.smileybackend._01_user.dto.user.UserDeviceDto;
import com.smiley.smileybackend._00_common.exception.ErrorCode;
import com.smiley.smileybackend._00_common.exception.ErrorException;
import com.smiley.smileybackend._02_userDevice.repository.UserDeviceRepository;
import com.smiley.smileybackend._01_user.repository.UserRepository;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@ToString
@Slf4j
public class UserDeviceService {
    private final UserDeviceRepository userDeviceRepository;
    private final UserRepository userRepository;

    public UserDeviceService(UserDeviceRepository userDeviceRepository, UserRepository userRepository) {
        this.userDeviceRepository = userDeviceRepository;
        this.userRepository = userRepository;
    }

    /**
     * 사용자 장치 정보 저장
     *
     * @author : 김성찬
     * @param : 장치 이름, 장치 타입 등이 저장된 UserDeviceDto Class
     * @return : 저장된 사용자 장치 정보
     * @throws : 이미 등록된 장치인 경우 DEVICE_ALREADY_REGISTER
     * @throws : 사용자 Index가 존재 하지 않으면 HOSPITAL_NOT_FOUND
     */
    public UserDeviceInfoDto adddevice(UserDeviceDto userDeviceDto) {
        User user = userRepository.findById(userDeviceDto.getUserNumber())
                .orElseThrow(() -> new ErrorException(ErrorCode.USER_NOT_FOUND));
        UserDevice userDevice;
        try {
            userDevice = userDeviceRepository.save(userDeviceDto.toEntity(user));
        } catch (DataIntegrityViolationException d) {
            throw new ErrorException(ErrorCode.DEVICE_ALREADY_REGISTER);
        }
        return new UserDeviceInfoDto(userDevice);
    }

}
