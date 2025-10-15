package com.example.shojo_anime.DTO.AnimeDetailsDTO;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class Attributes {
    private Title title;
    private List<Map<String,String>> altTitles ;
    private Description description;
    private String en;
    public void pushAlt() {
        for (Map<String, String> altTitle : altTitles) {
            if (altTitle == null) {
                continue;
            }
            if (altTitle.get("en") != null) {
                log.info("altTitle:{}", altTitle.get("en"));
                this.en = altTitle.get("en");
                break;
            }

        }
    }
    public void setAltTitles(List<Map<String,String>> altTitles) {
        this.altTitles = altTitles;
        pushAlt();
    }



}
