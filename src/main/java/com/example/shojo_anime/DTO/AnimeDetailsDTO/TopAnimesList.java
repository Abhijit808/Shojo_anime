package com.example.shojo_anime.DTO.AnimeDetailsDTO;

import lombok.Data;

import java.util.List;

@Data
public class TopAnimesList {
    private String result;
    private String response;
    private List<MangaInfo> data;
}
