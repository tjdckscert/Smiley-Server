package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.dto.response.HospitalInfoDto;
import com.smiley.smileybackend.dto.response.SimpleHospitalInfo;
import com.smiley.smileybackend.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalService {
    private HospitalRepository hospitalRepository;
    public HospitalService(HospitalRepository hospitalRepository){
        this.hospitalRepository=hospitalRepository;
    }

    /**
     * ID 값을 통해 단일 병원 정보를 가져온다
     * */
    public HospitalInfoDto findHospital(Integer id) {
        Hospital hospital = hospitalRepository.findByHospitalId(id).orElseThrow(
                () -> new IllegalArgumentException("병원을 찾을 수 없습니다")
        );
        return  new HospitalInfoDto(hospital);
    }

    /**
     * 모든 병원의 인덱스, 이름 ,주소만 가져온다
     * */
    public List<SimpleHospitalInfo> getSimpleHospitalInfo() {
        return hospitalRepository.findAll().stream().map(SimpleHospitalInfo::entityToDto).collect(Collectors.toList());
    }
}
