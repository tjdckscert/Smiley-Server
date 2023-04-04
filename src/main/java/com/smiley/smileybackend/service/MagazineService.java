package com.smiley.smileybackend.service;

import com.smiley.smileybackend.dto.response.MagazineInfoDto;
import com.smiley.smileybackend.repository.MagazineRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ToString
@Getter
@NoArgsConstructor
public class MagazineService {
    private MagazineRepository magazineRepository;
    public MagazineService(MagazineRepository magazineRepository){
        this.magazineRepository=magazineRepository;
    }

    public List<MagazineInfoDto> getAll() {
        List<MagazineInfoDto> magazineInfos = magazineRepository.findAll().stream().map(magazine -> new MagazineInfoDto(
                magazine.getId(),magazine.getTitle(),magazine.getSubTitle(),magazine.getAuthor(),magazine.getThumbnail(),magazine.getLikes(),magazine.getViewCount(),magazine.getContentLink()
        )).collect(Collectors.toList());
        return magazineInfos;
    }

}
