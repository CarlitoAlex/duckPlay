package com.example.demo.controllers;

import com.example.demo.models.SteamModel.Species;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class SteamController {
    public void getOwnersGames() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://swapi.dev/api/species/3/";
        Species steamDTO = restTemplate.getForObject(new URI(fooResourceUrl), Species.class);
        System.out.println(steamDTO.name);
        System.out.println(steamDTO.language);
    }
}
