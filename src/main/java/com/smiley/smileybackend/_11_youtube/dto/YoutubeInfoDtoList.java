package com.smiley.smileybackend._11_youtube.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class YoutubeInfoDtoList {
    List<YoutubeInfoDto> videos;

    @Builder
    public YoutubeInfoDtoList(List<YoutubeInfoDto> videos) {
        this.videos = videos;
    }
}
