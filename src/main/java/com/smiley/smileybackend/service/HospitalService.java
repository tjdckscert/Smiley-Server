package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.dto.response.HospitalInfoDto;
import com.smiley.smileybackend.dto.user.HospitalIdDto;
import com.smiley.smileybackend.repository.HospitalRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    private HospitalRepository hospitalRepository;
    public HospitalService(HospitalRepository hospitalRepository){
        this.hospitalRepository=hospitalRepository;
    }

    /**
     * ID 값을 통해 단일 병원 정보를 가져온다
     * */
    public HospitalInfoDto findHospital(HospitalIdDto hospitalIdDto) {
        Hospital hospital = hospitalRepository.findByHospitalId(hospitalIdDto.getHospitalId()).orElseThrow(
                () -> new IllegalArgumentException("병원을 찾을 수 없습니다")
        );
        return  new HospitalInfoDto(hospital);
    }
}
