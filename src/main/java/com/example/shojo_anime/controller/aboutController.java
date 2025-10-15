package com.example.shojo_anime.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class aboutController {
    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }
}
