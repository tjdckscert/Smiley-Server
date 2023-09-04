package com.smiley.smileybackend.service;


import com.smiley.smileybackend.domain.Drug;
import com.smiley.smileybackend.dto.response.DrugInfoDto;
import com.smiley.smileybackend.dto.response.dtolist.DrugInfoDtoList;
import com.smiley.smileybackend.exception.ErrorCode;
import com.smiley.smileybackend.exception.ErrorException;

import com.smiley.smileybackend.repository.DrugRepository;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DrugService {
    private final DrugRepository drugRepository;

    public DrugService(DrugRepository drugRepository){
        this.drugRepository = drugRepository;
    }

    @Value("${list.contraindicated.drugs-kor}")
    private List<String> contraindicatedDrugsKor;

    /**
     * itemCode로 의약품 정보를 가져온다
     *
     * @author : 김준
     * @param : 의약품 코드(itemCode)
     * @return : 선택 의약품 정보
     * @throws : 의약품이 존재 하지 않으면 MEDICINE_NOT_FOUND
     */
    public DrugInfoDto findDrug(String itemCode) {
        Drug drug = drugRepository.findById(itemCode).orElseThrow(
                () -> new ErrorException(ErrorCode.MEDICINE_NOT_FOUND)
        );
        return new DrugInfoDto(drug);
    }

    /**
     * 모든 의약품 정보 반환
     *
     * @author : 김준
     * @return : MedicineInfoDto를 List<> 객체로 가지는 MedicineInfoDtoList Class 반환
     */
    public DrugInfoDtoList getAll() {
        return new DrugInfoDtoList(drugRepository.findAll()
                .stream()
                .map(DrugInfoDto::entityToDto)
                .collect(Collectors.toList()));
    }

    /**
     * 의약품 정보를 모두 저장한다. (공공 API의 정보를 저장할 때 사용)
     *
     * @author : 김성찬
     * @param  : 저장할 의약품 정보 List
     */
    public void saveAll(List<Drug> drugs) {
        drugRepository.saveAll(drugs);
    }

    /**
     * 의약품 정보를 모두 저장한다. (공공 API의 정보를 저장할 때 사용)
     *
     * @author : 김성찬
     * @param  : 의약품 검사
     */
    public Map<String, Object> inspectionDrug(List<String> itemCodeList) {

        List<DrugInfoDto> drugs = new ArrayList<>();
        boolean isSafeForConsumption = true;


        for(String itemCode : itemCodeList)
        {
            DrugInfoDto drug = findDrug(itemCode);
            if(!drug.isSafeForConsumption())
            {
                // 복용 금지 성분
                for(String contraindicatedDrug : contraindicatedDrugsKor)
                {
                    if(drug.getItemSubstanceKor().contains(contraindicatedDrug));
                    // 복용 금지 약품이면 약품명 리스트에 저장

                }

            }
            drugs.add(findDrug(itemCode));
        }

        DrugInfoDtoList drugInfoDtoList = new DrugInfoDtoList(drugs);

        Map<String, Object> result = new HashMap<>();
        result.put("isSafe", isSafeForConsumption);
        result.put("drugs", drugInfoDtoList);

        return result;

    }


}
