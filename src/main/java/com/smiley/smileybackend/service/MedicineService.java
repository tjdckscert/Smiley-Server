package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Medicine;
import com.smiley.smileybackend.dto.response.MedicineInfoDto;
import com.smiley.smileybackend.dto.response.dtolist.MedicineInfoDtoList;
import com.smiley.smileybackend.repository.MedicineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MedicineService {
    private final MedicineRepository medicineRepository;
    public MedicineService(MedicineRepository medicineRepository){
        this.medicineRepository = medicineRepository;
    }
    /**
     * ID 값을 통해 단일 의약품 정보를 가져온다
     * */
    public MedicineInfoDto findMedicine(String itemCode) {
        Medicine medicine = medicineRepository.findById(itemCode).orElseThrow(
                () -> new IllegalArgumentException("의약품을 찾을 수 없습니다")
        );
        return new MedicineInfoDto(medicine);
    }

    /**
     * 모든 의약품 정보를 가져온다
     * */
    public MedicineInfoDtoList getAll() {
        return new  MedicineInfoDtoList(medicineRepository.findAll().stream().map(MedicineInfoDto::entityToDto).collect(Collectors.toList()));
    }

    /**
     * List 의약품 정보 저장
     * */
    public void saveAll(List<Medicine> medicines) {medicineRepository.saveAll(medicines);
    }
}
