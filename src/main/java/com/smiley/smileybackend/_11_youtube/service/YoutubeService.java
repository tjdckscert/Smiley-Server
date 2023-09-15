package com.smiley.smileybackend._11_youtube.service;


import com.smiley.smileybackend._00_common.exception.ErrorCode;
import com.smiley.smileybackend._00_common.exception.ErrorException;
import com.smiley.smileybackend._08_magazine.domain.Magazine;
import com.smiley.smileybackend._08_magazine.dto.MagazineDetailDto;
import com.smiley.smileybackend._08_magazine.dto.MagazineInfoDto;
import com.smiley.smileybackend._08_magazine.dto.MagazineInfoDtoList;
import com.smiley.smileybackend._08_magazine.repository.MagazineRepository;
import com.smiley.smileybackend._11_youtube.domain.Youtube;
import com.smiley.smileybackend._11_youtube.dto.YoutubeInfoDto;
import com.smiley.smileybackend._11_youtube.dto.YoutubeInfoDtoList;
import com.smiley.smileybackend._11_youtube.repository.YoutubeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Collectors;

@Service
@Slf4j
public class YoutubeService {
    private final YoutubeRepository youtubeRepository;
    public YoutubeService(YoutubeRepository youtubeRepository){
        this.youtubeRepository=youtubeRepository;
    }

    /**
     * 모든 유튜브 영상 정보를 가져온다
     */
    public YoutubeInfoDtoList getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return new YoutubeInfoDtoList(youtubeRepository.findAll(pageable)
                .stream()
                .map(YoutubeInfoDto::entityToDto)
                .collect(Collectors.toList()));
    }

    /**
     * 선택한 수량(number)만큼의 가장 최근 매거진 정보를 가져온다
     */
    public YoutubeInfoDtoList getListOfNumber(Integer number) {
        Pageable pageable = PageRequest.of(0,number);
        Page<Youtube> youtubePage = youtubeRepository.findAllByOrderByIdDesc(pageable);
        return new YoutubeInfoDtoList(youtubeRepository.findAllByOrderByIdDesc(pageable)
                .stream()
                .map(YoutubeInfoDto::entityToDto)
                .collect(Collectors.toList()));
    }

}
