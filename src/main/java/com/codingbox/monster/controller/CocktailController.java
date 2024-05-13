package com.codingbox.monster.controller;

import com.codingbox.monster.service.CocktailService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@RestController
@RequestMapping("/cocktails")
public class CocktailController {

    private final CocktailService cocktailService;

    @Autowired
    public CocktailController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping("/search")
    public String searchCocktails() {
        OkHttpClient client = new OkHttpClient.Builder().build();

        Request request = new Request.Builder()
                .url("https://the-cocktail-db.p.rapidapi.com/search.php?s=vodka")
                .get()
                .addHeader("X-RapidAPI-Key", "994a06b8f2mshbff0e95525f145fp1f054bjsn7eefc7c1bcf9")
                .addHeader("X-RapidAPI-Host", "the-cocktail-db.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseData = response.body().string();

                cocktailService.saveCocktailDataAsync(responseData);

                return responseData;
            } else {
                return "Failed to fetch cocktails";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error while fetching cocktails: " + e.getMessage();
        }
    }
}
