package com.example.shojo_anime.DTO.AnimeDetailsDTO;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
public class MangaInfo {
     private String id;
     private String type;
     private Attributes attributes;
     private List<relations> relationships;
     private String imgSrc;

}
