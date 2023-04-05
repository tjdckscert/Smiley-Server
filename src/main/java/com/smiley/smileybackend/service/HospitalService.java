package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.dto.response.HospitalInfoDto;
import com.smiley.smileybackend.dto.response.SimpleHospitalInfo;
import com.smiley.smileybackend.repository.HospitalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalService {
    private HospitalRepository hospitalRepository;
    private ModelMapper modelMapper;
    public HospitalService(HospitalRepository hospitalRepository, ModelMapper modelMapper){
        this.hospitalRepository=hospitalRepository;
        this.modelMapper=modelMapper;
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

    public List<SimpleHospitalInfo> getSimpleHospitalInfo() {
        return hospitalRepository.findAll().stream().map(hospital -> modelMapper.map(hospital, SimpleHospitalInfo.class)).collect(Collectors.toList());
    }
}
