package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Magazine;
import com.smiley.smileybackend.dto.response.MagazineDetailDto;
import com.smiley.smileybackend.dto.response.MagazineInfoDto;
import com.smiley.smileybackend.dto.response.dtolist.MagazineInfoDtoList;
import com.smiley.smileybackend.exception.ErrorCode;
import com.smiley.smileybackend.exception.ErrorException;
import com.smiley.smileybackend.repository.MagazineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MagazineService {
    private final MagazineRepository magazineRepository;
    public MagazineService(MagazineRepository magazineRepository){
        this.magazineRepository=magazineRepository;
    }

    /**
     * 모든 매거진 정보를 가져온다
     *
     * @author : 김성찬
     * @return : 모든 매거진 정보
     */
    public MagazineInfoDtoList getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return new MagazineInfoDtoList(magazineRepository.findAll(pageable)
                .stream()
                .map(MagazineInfoDto::entityToDto)
                .collect(Collectors.toList()));
    }

    /**
     * 선택한 수량(number)만큼의 매거진 정보를 가져온다
     *
     * @author : 김성찬
     * @param : 매거진 수량
     * @return : 선택 수량 만큼의 매거진
     */
    public MagazineInfoDtoList getListOfNumber(Integer number) {
        Pageable pageable = PageRequest.of(0,number);
        Page<Magazine> magazinePage = magazineRepository.findAllByOrderByIdDesc(pageable);
        return new MagazineInfoDtoList(magazineRepository.findAllByOrderByIdDesc(pageable)
                .stream()
                .map(MagazineInfoDto::entityToDto)
                .collect(Collectors.toList()));
    }

    /**
     * 선택한 매거진(index)의 정보를 가져온다 
     *
     * @author : 김성찬
     * @param : 매거진 번호(index)
     * @return : 선택한 매거진 정보
     * @throws : 매거진이 존재 하지 않으면 MAGAZINE_NOT_FOUND
     * @throws : 사진이 존재 하지 않으면 PICTURE_NOT_FOUND
     */
    public MagazineDetailDto getMagazineDetail(Integer number) {
        Magazine magazine = magazineRepository.findById(number).orElseThrow(
                () -> new ErrorException(ErrorCode.MAGAZINE_NOT_FOUND)
        );
        byte[] img;
        try {
            InputStream inputStream = new FileInputStream(magazine.getThumbnail());
            long fileSize = new File(magazine.getThumbnail()).length();
            img = new byte[(int) fileSize];
            while (inputStream.read(img) > 0) ;
            inputStream.close();
        } catch (IOException e) {
            throw new ErrorException(ErrorCode.PICTURE_NOT_FOUND);
        }
        return new MagazineDetailDto(magazine,img);
    }

}
