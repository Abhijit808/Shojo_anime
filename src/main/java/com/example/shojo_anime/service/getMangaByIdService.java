package com.example.shojo_anime.service;

import com.example.shojo_anime.DTO.AnimeDetailsDTO.animeByID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class getMangaByIdService {
    @Autowired
    RestTemplate restTemplate;

    public animeByID getMangaById(String url, String id) {
        // Logic to retrieve manga by ID
        animeByID mangaInfo = restTemplate.getForObject(url + id, animeByID.class);
        log.info("mangaInfo {}", mangaInfo);

        return mangaInfo;
    }

}
