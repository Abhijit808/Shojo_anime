package com.example.shojo_anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.shojo_anime.DTO.AnimeDetailsDTO.animeByID;
import com.example.shojo_anime.service.getCoverImageFileName;
import com.example.shojo_anime.service.getMangaByIdService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RestController
@RequestMapping("/covers")
public class coversProxy {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private getCoverImageFileName coverImageFileNameService;
    @Autowired
    private getMangaByIdService mangaByIdService;

    public coversProxy(getCoverImageFileName coverImageFileNameService,
            getMangaByIdService mangaByIdService) {
        this.coverImageFileNameService = coverImageFileNameService;
        this.mangaByIdService = mangaByIdService;
    }

    private final String url = "https://api.mangadex.org/manga/";

    @GetMapping("/{mangaId}")
    public ResponseEntity<byte[]> getCoverImages(@PathVariable String mangaId) {
        log.info("Fetching cover image for manga ID: " + mangaId);
        animeByID mangaDetails = mangaByIdService.getMangaById(url, mangaId);
        String coverImageUrl = coverImageFileNameService.getFileName(mangaDetails);
        byte[] imageBytes = restTemplate.getForObject(coverImageUrl, byte[].class);

        return new ResponseEntity<byte[]>(imageBytes, HttpStatus.OK);
    }

}