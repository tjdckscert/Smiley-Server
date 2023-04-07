package com.smiley.smileybackend.service;

import com.smiley.smileybackend.dto.response.MagazineInfoDto;
import com.smiley.smileybackend.dto.response.dtolist.MagazineInfoDtoList;
import com.smiley.smileybackend.repository.MagazineRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
public class MagazineService {
    private MagazineRepository magazineRepository;
    public MagazineService(MagazineRepository magazineRepository){
        this.magazineRepository=magazineRepository;
    }

    /**
     * 모든 매거진 정보를 가져온다
     * */
    public MagazineInfoDtoList getAll() {
        return new MagazineInfoDtoList(magazineRepository.findAll().stream().map(MagazineInfoDto::entityToDto).collect(Collectors.toList()));
    }

    /**
     * 선택한 수량만큼의 매거진 정보를 가져온다
     * */
    public MagazineInfoDtoList getListOfNumber(Integer number) {
        Pageable pageable = PageRequest.of(0,number);
        return new MagazineInfoDtoList(magazineRepository.findAllByOrderByIdDesc(pageable).stream().map(MagazineInfoDto::entityToDto).collect(Collectors.toList()));
    }

}
