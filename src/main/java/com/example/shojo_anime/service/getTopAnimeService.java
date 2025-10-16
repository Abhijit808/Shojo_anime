package com.example.shojo_anime.service;

import com.example.shojo_anime.DTO.AnimeDetailsDTO.TopAnimesList;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class getTopAnimeService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    public final getCoverImageFileName getCover;

    public getTopAnimeService(getCoverImageFileName getCover) {
        this.getCover = getCover;
    }

    public TopAnimesList getTopAnime() {
        String url = "https://api.mangadex.org/manga?publicationDemographic[]=shoujo&limit=10&order[followedCount]=desc";
        ResponseEntity<TopAnimesList> response = restTemplate.getForEntity(url, TopAnimesList.class);

        // if (response.getBody() != null) {
        // getCover.getFileName(response.getBody());
        // }
        return response.getBody();
    }

}
