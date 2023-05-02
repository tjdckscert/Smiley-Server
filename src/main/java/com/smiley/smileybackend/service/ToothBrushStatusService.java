package com.smiley.smileybackend.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Transactional
@Slf4j
@PropertySource("classpath:application-path.properties") // MainApplication로 옮기는 거 생각
public class ToothBrushStatusService {

    @Value("${property.toothbrush.image.request-path}")
    private String requestPath;



    // 1. 요청 들어온 사진 서버에 저장하기
    public void saveFile(String userId, MultipartFile imageFile) throws IOException {

        log.info("들어온 사진 이름 확인: " + imageFile.getOriginalFilename());

        // 해당 경로에 USER ID를 이름으로 이미지 저장
        String saveFileName = requestPath + userId + ".jpg";
        imageFile.transferTo(new File(saveFileName));   // 사진 저장

    }

    // 2. 기존에 저장되어 있는 파일 삭제 ( 폴더가 아이디 이름으로 되어 있음 ) -> YOLO가 동일 이름으로 들어오면 이름을 바꿔버림
    public void deleteOriginalFile(String userId){
        File file = new File("C:\\Users\\joon\\Desktop\\ToothFairy_Server\\src\\main\\python\\toothbrush\\yolov5\\runs\\detect\\"+userId);

        if(!file.exists()){ // 기존에 저장된 파일이 없다면
            log.info("삭제할 파일이 존재하지 않습니다.");
        }
        else // 기존에 저장된 파일이 있다면 삭제 처리
        {
            if(file.isDirectory()) { //파일이 디렉토리인지 확인 -> 디렉토리가 비워있지 않다면 삭제가 안됨
                log.info("기존 파일 존재 - 삭제 진행");
                File[] files = file.listFiles();
                for( int i=0; i<files.length; i++){ // 디렉터리에 있는 내부 파일들을 모두 삭제
                    if( files[i].delete() ){
                        log.info("폴더 내부 파일 삭제 성공");
                    }else{
                        log.info("폴더 내부 파일 삭제 실패");
                    }
                }
            }
            if(file.delete()){
                log.info("파일삭제 성공");
            }else{
                log.info("파일삭제 실패");
            }
        }

    }

    // 3. 이미지 학습 시키기

    // 4. 학습된 파일 가져오기




}
