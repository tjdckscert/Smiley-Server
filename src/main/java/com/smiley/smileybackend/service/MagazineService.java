package com.smiley.smileybackend.service;

import com.smiley.smileybackend.dto.response.MagazineInfoDto;
import com.smiley.smileybackend.repository.MagazineRepository;
import org.modelmapper.ModelMapper;
import com.smiley.smileybackend.domain.Magazine;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
@Service
public class MagazineService {
    private MagazineRepository magazineRepository;
    private ModelMapper modelMapper;
    public MagazineService(MagazineRepository magazineRepository, ModelMapper modelMapper){
        this.magazineRepository=magazineRepository;
        this.modelMapper=modelMapper;
    }

    public List<MagazineInfoDto> getAll() {
        return magazineRepository.findAll().stream().map(magazine -> modelMapper.map(magazine,MagazineInfoDto.class)).collect(Collectors.toList());
    }

}
