package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Medicine;
import com.smiley.smileybackend.dto.response.MedicineInfoDto;
import com.smiley.smileybackend.dto.response.dtolist.MedicineInfoDtoList;
import com.smiley.smileybackend.exception.ErrorCode;
import com.smiley.smileybackend.exception.ErrorException;
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
     * itemCode로 의약품 정보를 가져온다
     *
     * @author : 김성찬
     * @param : 의약품 코드(itemCode)
     * @return : 선택 의약품 정보
     * @throws : 의약품이 존재 하지 않으면 MEDICINE_NOT_FOUND
     */
    public MedicineInfoDto findMedicine(String itemCode) {
        Medicine medicine = medicineRepository.findById(itemCode).orElseThrow(
                () -> new ErrorException(ErrorCode.MEDICINE_NOT_FOUND)
        );
        return new MedicineInfoDto(medicine);
    }

    /**
     * 모든 의약품 정보 반환
     *
     * @author : 김성찬
     * @return : MedicineInfoDto를 List<> 객체로 가지는 MedicineInfoDtoList Class 반환
     */
    public MedicineInfoDtoList getAll() {
        return new  MedicineInfoDtoList(medicineRepository.findAll()
                .stream()
                .map(MedicineInfoDto::entityToDto)
                .collect(Collectors.toList()));
    }

    /**
     * 의약품 정보를 모두 저장한다. (공공 API의 정보를 저장할 때 사용)
     *
     * @author : 김성찬
     * @param  : 저장할 의약품 정보 List
     */
    public void saveAll(List<Medicine> medicines) {medicineRepository.saveAll(medicines);
    }
}
