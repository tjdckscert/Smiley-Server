package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.dto.response.HospitalGeocodingDto;
import com.smiley.smileybackend.dto.response.HospitalInfoDto;
import com.smiley.smileybackend.dto.response.SimpleHospitalInfoDto;
import com.smiley.smileybackend.dto.response.dtolist.HospitalGeocodingDtoList;
import com.smiley.smileybackend.dto.response.dtolist.HospitalInfoDtoList;
import com.smiley.smileybackend.dto.response.dtolist.SimpleHospitalInfoDtoList;
import com.smiley.smileybackend.dto.user.UserGeocodingDto;
import com.smiley.smileybackend.exception.ErrorCode;
import com.smiley.smileybackend.exception.ErrorException;
import com.smiley.smileybackend.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    public HospitalService(HospitalRepository hospitalRepository){
        this.hospitalRepository=hospitalRepository;
    }

    /**
     * ID 값을 통해 단일 병원 정보를 가져온다
     * @author : 김성찬
     * @param : 조회할 병원 ID
     * @return : 병원 정보
     * @throws : 병원 id가 존재 하지 않으면 HOSPITAL_NOT_FOUND
     */
    public HospitalInfoDto findHospital(String hPid) {
        Hospital hospital = hospitalRepository.findByHPid(hPid).orElseThrow(
                () -> new ErrorException(ErrorCode.HOSPITAL_NOT_FOUND)
        );
        return  new HospitalInfoDto(hospital);
    }

    /**
     * 모든 병원의 인덱스, 이름 ,주소만 가져온다
     *
     * @author : 김성찬
     * @return : SimpleHospitalInfoDto를 List<> 객체로 가지는 SimpleHospitalInfoDtoList Class 반환
     */
    public SimpleHospitalInfoDtoList getSimpleHospitalInfo() {
        return new SimpleHospitalInfoDtoList(hospitalRepository.findAll()
                .stream()
                .map(SimpleHospitalInfoDto::entityToDto)
                .collect(Collectors.toList()));
    }

    /**
     * 병원 정보를 모두 저장한다. (공공 API의 정보를 저장할 때 사용)
     *
     * @author : 김성찬
     * @param  : 저장할 병원 정보 List
     */
    public void saveAll(List<Hospital> hospitals) {
        hospitalRepository.saveAll(hospitals);
    }

    /**
     * 모든 병원의 인덱스, 이름 ,주소만 가져온다
     * @author : 김성찬
     * @return : HospitalInfoDto를 List<> 객체로 가지는 HospitalInfoDtoList Class 반환
     */
    public HospitalInfoDtoList getHospitalInfos() {
        return new HospitalInfoDtoList(hospitalRepository.findAll()
                .stream()
                .map(HospitalInfoDto::entityToDto)
                .collect(Collectors.toList()));
    }

    /**
     * 사용자 근처에 있는 병원리스트를 반환한다.
     * @author : 김성찬
     * @param : 사용자의 공간 좌표가 저장된 UserGeocodingDto Class
     * @return : UserGeocodingDto.distance 내에 있는 병원 정보
     */
    public HospitalGeocodingDtoList getNearHospitalInfos(UserGeocodingDto userGeocodingDto) {
        return new HospitalGeocodingDtoList(hospitalRepository.findNearHospitals(userGeocodingDto.getDistance(),userGeocodingDto.getLatitude(),userGeocodingDto.getLongitude())
                .stream()
                .map(HospitalGeocodingDto::entityToDto)
                .collect(Collectors.toList()));
    }
}
