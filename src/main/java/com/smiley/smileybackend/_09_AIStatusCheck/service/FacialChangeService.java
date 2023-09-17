package com.smiley.smileybackend._09_AIStatusCheck.service;


import com.smiley.smileybackend._09_AIStatusCheck.dto.FacialChangeImageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;

@Service
@Transactional
@Slf4j
@PropertySource("classpath:application-path.properties")
public class FacialChangeService extends RunPythonService {

    @Value("${property.protrusionmouth.image.request-path}")
    private String requestPath;
    @Value("${property.protrusionmouth.image.response-path}")
    private String responsePath;
    @Value("${property.protrusionmouth.python.learning-file}")
    private String learningFile;



    public FacialChangeImageDto facialChangeCheck(String userId, MultipartFile imageFile) throws IOException {

        saveFile(userId, imageFile, requestPath);
        runPython(userId);
        // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
        // 오늘 날짜로 이미지 파일이 생성됨 ex) 2023-07-30
        String todayDate = LocalDate.now().toString();
        return getTrainedFile(userId, todayDate);
    }

    // 1. 요청 들어온 사진 서버에 저장하기


    // 2. 이미지 학습 시키기
    public void runPython(String userId){

        log.info("주걱턱 - 파이썬 실행");
        String command = String.format("python3 %s %s", learningFile, userId);
        run(command);
    }

    // 3. 학습된 파일 가져오기
    public FacialChangeImageDto getTrainedFile(String userId, String date){

        String imagePath = String.format("%s/%s.jpg", responsePath+userId, date);

        FacialChangeImageDto facialChangeImageDto = new FacialChangeImageDto();

        try {
            InputStream inputStream = new FileInputStream(imagePath);
            long fileSize = new File(imagePath).length();
            facialChangeImageDto.setImage(new byte[(int) fileSize]);
            while (inputStream.read(facialChangeImageDto.getImage()) > 0);
            inputStream.close();
        }catch (FileNotFoundException e) {
            log.info("파일없음");
        } catch (IOException e) {
            log.info("IOException",e);
        }

        return facialChangeImageDto;
    }

    public boolean deleteTrainedFile(String userId, String date) {
        //파일 경로 지정
        String imagePath = String.format("%s/%s.jpg", responsePath + userId, date);
        boolean status = false;
        //현재 게시판에 존재하는 파일객체를 만듬
        File file = new File(imagePath);

        if (file.exists()) {
            if (file.delete()) {
                log.info("파일삭제 성공");
                status = true;

            } else {
                log.info("파일삭제 실패");
            }
        } else {
            log.info("파일이 존재하지 않습니다.");
        }
        return status;
    }

}
