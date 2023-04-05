package com.smiley.smileybackend.service;

import com.smiley.smileybackend.dto.response.MagazineInfoDto;
import com.smiley.smileybackend.repository.MagazineRepository;
import org.springframework.stereotype.Service;


import java.util.List;
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
    public List<MagazineInfoDto> getAll() {
        return magazineRepository.findAll().stream().map(MagazineInfoDto::entityToDto).collect(Collectors.toList());
    }

}
