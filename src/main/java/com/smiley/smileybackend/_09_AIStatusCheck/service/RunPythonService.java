package com.smiley.smileybackend._09_AIStatusCheck.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class RunPythonService {

    // 1. 요청 들어온 사진 서버에 저장하기
    public void saveFile(String userId, MultipartFile imageFile, String requestPath) throws IOException {

        log.info("input image name: " + imageFile.getOriginalFilename());

        // 해당 경로에 USER ID를 이름으로 이미지 저장
        String saveFileName = requestPath + userId + ".jpg";
        log.info(saveFileName);
        imageFile.transferTo(new File(saveFileName));   // 사진 저장

    }

    //리눅스 쉘 파이썬 실행
    public void run(String command){
        log.info("실행 명령어 : "+command);
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.getErrorStream().close();
            process.getInputStream().close();
            process.getOutputStream().close();
            process.waitFor();
        } catch (InterruptedException e) {
            log.info("InterruptedException",e);
            Thread.currentThread().interrupt();

        } catch (Exception e) {
            log.info("Exception",e);
        }
    }




}
