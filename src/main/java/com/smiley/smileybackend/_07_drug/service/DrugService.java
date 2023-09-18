package com.smiley.smileybackend._07_drug.service;


import com.smiley.smileybackend._00_common.exception.ErrorCode;
import com.smiley.smileybackend._00_common.exception.ErrorException;
import com.smiley.smileybackend._07_drug.domain.Drug;
import com.smiley.smileybackend._07_drug.dto.ContraindicatedDrugDto;
import com.smiley.smileybackend._07_drug.dto.ContraindicatedDrugResponseDto;
import com.smiley.smileybackend._07_drug.dto.DrugInfoDto;
import com.smiley.smileybackend._07_drug.repository.ContraindicatedDrugRepository;
import com.smiley.smileybackend._07_drug.dto.DrugInfoDtoList;


import com.smiley.smileybackend._07_drug.repository.DrugRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DrugService {
    private final DrugRepository drugRepository;
    private final ContraindicatedDrugRepository contraindicatedDrugRepository;

    public DrugService(DrugRepository drugRepository, ContraindicatedDrugRepository contraindicatedDrugRepository){
        this.drugRepository = drugRepository;
        this.contraindicatedDrugRepository = contraindicatedDrugRepository;
    }

    /**
     * itemCode로 의약품 정보를 가져온다
    **/
    public DrugInfoDto findDrug(String itemCode) {
        Drug drug = drugRepository.findById(itemCode).orElseThrow(
                () -> new ErrorException(ErrorCode.MEDICINE_NOT_FOUND)
        );
        return new DrugInfoDto(drug);
    }

    /**
     * 모든 의약품 정보 반환
    */
    public DrugInfoDtoList getAll() {
        return new DrugInfoDtoList(drugRepository.findAll()
                .stream()
                .map(DrugInfoDto::entityToDto)
                .collect(Collectors.toList()));
    }

    /**
     * 금지 성분 추가
     */
    public void addContraindicatedDrug(@Valid ContraindicatedDrugDto contraindicatedDrugDto) {
        contraindicatedDrugRepository.save(contraindicatedDrugDto.toEntity());
    }

    /**
     * 금지 성분 리스트 가져오기
     */
    public ContraindicatedDrugDto getContraindicatedDrug(String itemNameKor){
        return new ContraindicatedDrugDto(contraindicatedDrugRepository.findByItemNameKor(itemNameKor));

    }

    /**
     * 금지 성분 이름 리스트 가져오기
     */
    public List<String> getContraindicatedDrug2(){
        return contraindicatedDrugRepository.findAllItemName();
    }

    /**
     * 의약품 정보를 모두 저장한다. (공공 API의 정보를 저장할 때 사용)
    */
    public void saveAll(List<Drug> drugs) {
        drugRepository.saveAll(drugs);
    }

    /**
     * 의약품 검사
     */
    public Map<String, Object> inspectionDrug(List<String> itemCodeList) {

        List<DrugInfoDto> drugs = new ArrayList<>();
        List<ContraindicatedDrugResponseDto> contraindicatedDrugResponseDtos = new ArrayList<>();

        //복용 금지 성분 이름 리스트
        List<String> contraindicatedDrugsKor = getContraindicatedDrug2();

        for(String itemCode : itemCodeList)
        {
            List<ContraindicatedDrugDto> contraindicatedDrugList = new ArrayList<>();

            DrugInfoDto drug = findDrug(itemCode);
            if(!drug.isSafeForConsumption())
            {
                //복용 금지 약품 이름

                // 복용 금지 성분 확인
                for(String contraindicatedDrug : contraindicatedDrugsKor)
                {

                    if(drug.getItemSubstanceKor().contains(contraindicatedDrug)) {
                        // 복용 금지 약품이면 성분명 및 설명 리스트에 저장
                        log.info(contraindicatedDrug);
                        ///findby이름 으로 전체 dto 저장 후 리스트 생성
                        log.info(getContraindicatedDrug(contraindicatedDrug).toString());
                        contraindicatedDrugList.add(getContraindicatedDrug(contraindicatedDrug));

                    }

                }
                ContraindicatedDrugResponseDto contraindicatedDrugResponseDto = new ContraindicatedDrugResponseDto(drug.getItemNameKor(), contraindicatedDrugList);
                contraindicatedDrugResponseDtos.add(contraindicatedDrugResponseDto);
            }
            drugs.add(findDrug(itemCode));
        }

        Map<String, Object> result = new HashMap<>();
        result.put("danger", contraindicatedDrugResponseDtos);
        result.put("drugs", drugs);

        return result;

    }

}
