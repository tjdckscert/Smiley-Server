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



    public void saveFile(String userId, MultipartFile imageFile) throws IOException {

        log.info("들어온 사진 이름 확인: " + imageFile.getOriginalFilename());

        String saveFileName = requestPath + userId + ".jpg";

        imageFile.transferTo(new File(saveFileName));
        //deleteOriginalFile();
        //runPython();
    }
}
