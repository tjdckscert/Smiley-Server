package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Medicine;
import com.smiley.smileybackend.dto.response.MagazineInfoDto;
import com.smiley.smileybackend.dto.response.MedicineInfoDto;
import com.smiley.smileybackend.repository.MedicineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public MedicineInfoDto findMedicine(Integer id) {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("의약품을 찾을 수 없습니다")
        );
        return new MedicineInfoDto(medicine);
    }

    public List<MedicineInfoDto> getAll() {
        List<MedicineInfoDto> magazineInfos = medicineRepository.findAll().stream().map(medicine -> new MedicineInfoDto(
                medicine.getId(),medicine.getEntpName(),medicine.getItemName(),medicine.getItemSeq(),medicine.getEfcyQesitm(),medicine.getUseMethodQesitm(),medicine.getAtpnWarnQesitm(),medicine.getAtpnQesitm(),medicine.getIntrcQesitm(),medicine.getSeQesitm(),medicine.getDepositMethodQesitm(),medicine.getOpenDe(),medicine.getUpdateDe(),medicine.getItemImage()
        )).collect(Collectors.toList());
        return magazineInfos;
    }
}
