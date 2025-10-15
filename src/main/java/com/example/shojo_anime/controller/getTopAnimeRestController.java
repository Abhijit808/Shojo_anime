package com.example.shojo_anime.controller;

import com.example.shojo_anime.DTO.AnimeDetailsDTO.TopAnimesList;
import com.example.shojo_anime.service.getTopAnimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class getTopAnimeRestController {
    String url = "https://api.mangadex.org/manga/?order[followedCount]=desc";
    @Autowired
    private final getTopAnimeService getTop;

    // @Autowired
    // private final getCoverImageFileName getCover;
    // public getTopAnimeRestController(getTopAnimeService getTop) {
    // this.getTop = getTop;
    // }
    public getTopAnimeRestController(getTopAnimeService getTop) {
        this.getTop = getTop;
        // this.getCover = getCover;
    }

    @GetMapping("/top")
    public TopAnimesList topAnime() {
        log.info("getTopAnimeRestController topAnime");

        // log.info("coverImage{}", );
        return getTop.getTopAnime();

    }
}
