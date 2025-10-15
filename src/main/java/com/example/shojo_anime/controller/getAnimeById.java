package com.example.shojo_anime.controller;

import com.example.shojo_anime.DTO.AnimeDetailsDTO.animeByID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.shojo_anime.service.getMangaByIdService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class getAnimeById {
    private final String url = "https://api.mangadex.org/manga/";
    @Autowired
    private getMangaByIdService mangadetails;

    public getAnimeById(getMangaByIdService mangadetails) {
        this.mangadetails = mangadetails;
    }

    @GetMapping("/anime/{id}")
    public String getAnime(@PathVariable String id, Model model) {
        // Logic to retrieve anime by ID
        log.info("id: {}", id);
        animeByID mangaInfo = mangadetails.getMangaById(url, id);
        model.addAttribute("animeId", mangaInfo);
        return "animeDetails";
    }
}
