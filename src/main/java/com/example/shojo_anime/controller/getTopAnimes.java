package com.example.shojo_anime.controller;

import com.example.shojo_anime.DTO.AnimeDetailsDTO.TopAnimesList;
import com.example.shojo_anime.service.getCoverImageFileName;
import com.example.shojo_anime.service.getTopAnimeService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class getTopAnimes {

    @Autowired
    public final getTopAnimeService fetchAnime;
    @Autowired
    public final getCoverImageFileName getCover;
    public getTopAnimes(getTopAnimeService fetchAnime,getCoverImageFileName getCover) {
        this.fetchAnime = fetchAnime;
        this.getCover = getCover;
    }

    @GetMapping("/")
    public String getTopAnime(Model model) {
        log.info("atController {}", fetchAnime.getTopAnime().toString());

        TopAnimesList anime = fetchAnime.getTopAnime();
        log.info("getTopAnime {}", anime.toString());
        model.addAttribute("anime", anime);
        return "index";
    }

}
