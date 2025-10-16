package com.example.shojo_anime.service;

import com.example.shojo_anime.DTO.AnimeDetailsDTO.MangaInfo;

import com.example.shojo_anime.DTO.AnimeDetailsDTO.animeByID;
import com.example.shojo_anime.DTO.AnimeDetailsDTO.relations;
import com.example.shojo_anime.DTO.coverDTO.coverFileName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class getCoverImageFileName {
    @Autowired
    private RestTemplate restTemplate;

    // public void getFileName(TopAnimesList topAnimesList) {
    // List<MangaInfo> mangaInfoList = topAnimesList.getData();
    // for (MangaInfo mangaInfo : mangaInfoList) {

    // List<relations> relation = mangaInfo.getRelationships();
    // for (relations relations : relation) {
    // if (relations.getType().equals("cover_art")) {

    // String coverUrl = "https://api.mangadex.org/cover/" + relations.getId();

    // coverFileName cfm = restTemplate.getForObject(coverUrl, coverFileName.class);

    // if (cfm != null) {
    // log.info("cfm:{}", cfm.getData().getAttributes().getFileName());
    // mangaInfo.setImgSrc("https://uploads.mangadex.org/covers/" +
    // mangaInfo.getId() + "/"
    // + cfm.getData().getAttributes().getFileName());
    // }
    // }
    // }

    // }

    // }

    public String getFileName(animeByID anime) {
        MangaInfo mangaInfo = anime.getData();

        List<relations> relation = mangaInfo.getRelationships();
        for (relations relations : relation) {
            if (relations.getType().equals("cover_art")) {

                String coverUrl = "https://api.mangadex.org/cover/" + relations.getId();

                coverFileName cfm = restTemplate.getForObject(coverUrl, coverFileName.class);

                if (cfm != null) {
                    log.info("cfm:{}", cfm.getData().getAttributes().getFileName());
                    return "https://uploads.mangadex.org/covers/" + mangaInfo.getId() + "/"
                            + cfm.getData().getAttributes().getFileName();
                }
            }
        }
        return null;
    }
}
