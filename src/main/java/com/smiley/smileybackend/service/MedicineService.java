package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Medicine;
import com.smiley.smileybackend.dto.response.MedicineInfoDto;
import com.smiley.smileybackend.dto.user.MedicineIdDto;
import com.smiley.smileybackend.repository.MedicineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@Slf4j
public class MedicineService {
    private MedicineRepository medicineRepository;
    public MedicineService(MedicineRepository medicineRepository){
        this.medicineRepository = medicineRepository;
    }
    /**
     * ID 값을 통해 단일 의약품 정보를 가져온다
     * */
    public MedicineInfoDto findMedicine(@Valid MedicineIdDto medicineIdDto) {
        Medicine medicine = medicineRepository.findById(medicineIdDto.getId()).orElseThrow(
                () -> new IllegalArgumentException("의약품을 찾을 수 없습니다")
        );
        return new MedicineInfoDto(medicine);
    }
}
