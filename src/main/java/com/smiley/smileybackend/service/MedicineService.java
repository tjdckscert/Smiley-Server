package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Medicine;
import com.smiley.smileybackend.dto.response.MedicineInfoDto;
import com.smiley.smileybackend.repository.MedicineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======

>>>>>>> 951f54c6c570cb020256d227f320bf33249c1d1b
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
<<<<<<< HEAD

=======
>>>>>>> 951f54c6c570cb020256d227f320bf33249c1d1b
    public MedicineInfoDto findMedicine(Integer id) {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("의약품을 찾을 수 없습니다")
        );
        return new MedicineInfoDto(medicine);
    }
}
