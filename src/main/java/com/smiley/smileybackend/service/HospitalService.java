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
     * */
    public HospitalInfoDto findHospital(String hPid) {
        Hospital hospital = hospitalRepository.findByHPid(hPid).orElseThrow(
                () -> new ErrorException(ErrorCode.HOSPITAL_NOT_FOUND)
        );
        return  new HospitalInfoDto(hospital);
    }

    /**
     * 모든 병원의 인덱스, 이름 ,주소만 가져온다
     * */
    public SimpleHospitalInfoDtoList getSimpleHospitalInfo() {
        return new SimpleHospitalInfoDtoList(hospitalRepository.findAll()
                .stream()
                .map(SimpleHospitalInfoDto::entityToDto)
                .collect(Collectors.toList()));
    }

    public void saveAll(List<Hospital> hospitals) {
        hospitalRepository.saveAll(hospitals);
    }

    public HospitalInfoDtoList getHospitalInfos() {

        return new HospitalInfoDtoList(hospitalRepository.findAll()
                .stream()
                .map(HospitalInfoDto::entityToDto)
                .collect(Collectors.toList()));
    }
    public HospitalGeocodingDtoList getNearHospitalInfos(UserGeocodingDto userGeocodingDto) {
        return new HospitalGeocodingDtoList(hospitalRepository.findNearHospitals(userGeocodingDto.getDistance(),userGeocodingDto.getLatitude(),userGeocodingDto.getLongitude())
                .stream()
                .map(HospitalGeocodingDto::entityToDto)
                .collect(Collectors.toList()));
    }
}
