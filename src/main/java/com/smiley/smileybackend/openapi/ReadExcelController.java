package com.smiley.smileybackend.openapi;

import com.smiley.smileybackend.drug.domain.Drug;
import com.smiley.smileybackend.drug.service.DrugService;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class ReadExcelController {

    private final DrugService drugService;

    @Value("${list.contraindicated.drugs-kor}")
    private List<String> contraindicatedDrugsKor;

    @Value("${list.contraindicated.drugs-eng}")
    private List<String> contraindicatedDrugsEng;

    public ReadExcelController(DrugService drugService) {
        this.drugService = drugService;
    }

    @PostMapping("/upload-excel/medicine")
    @ApiOperation(value="의약품안전나라(https://nedrug.mfds.go.kr/searchDrug)에서 제공하는 의약품 제품 정보 엑셀 파일 사용" , notes = "의약품 엑셀파일 보내면 읽어서 DB에 저장한다.")
    public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            Workbook workbook = new XSSFWorkbook(inputStream); // 엑셀 워크북 생성

            Sheet sheet = workbook.getSheetAt(0); // 첫 번째 시트 가져오기

            List<Drug> drugs = new ArrayList<>();

            for (Row row : sheet) {

                //숫자로만 이루어진 String Type Data(의약품코드)를 poi에서 숫자로 인식하는 문제때문에 사용
                String itemCode = "";
                Cell itemCodeCell = row.getCell(0); // itemCode 셀 가져오기
                if (itemCodeCell != null) {
                    if (itemCodeCell.getCellType() == CellType.STRING) {
                        itemCode = itemCodeCell.getStringCellValue();
                    } else if (itemCodeCell.getCellType() == CellType.NUMERIC) {
                        itemCode = String.valueOf((int) itemCodeCell.getNumericCellValue());
                    }
                }

                // 복용 가능 여부 검사
                boolean isSafeForConsumption = true;
                // 복용 가능 여부 물질 리스트
                for(String drug : contraindicatedDrugsKor)
                {
                     if(row.getCell(3).getStringCellValue().contains(drug))
                        isSafeForConsumption = false;

                }
                for(String drug : contraindicatedDrugsEng) {
                    if(row.getCell(4).getStringCellValue().toLowerCase().contains(drug.toLowerCase()))
                        isSafeForConsumption = false;
                }

                Drug drug = Drug.builder()
                                .itemCode(itemCode)
                                .itemNameKor(row.getCell(1).getStringCellValue())
                                .itemNameEng(row.getCell(2).getStringCellValue())
                                .itemSubstanceKor(row.getCell(3).getStringCellValue())
                                .itemSubstanceEng(row.getCell(4).getStringCellValue())
                                .professionalism(row.getCell(5).getStringCellValue())
                                .isSafeForConsumption(isSafeForConsumption)
                                .build();

                drugs.add(drug);
            }
            drugService.saveAll(drugs); // 엔티티 저장


            workbook.close();
            inputStream.close();

            return ResponseEntity.ok("Excel data uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading Excel data.");
        }
    }
}