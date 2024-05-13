package com.codingbox.monster.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class CocktailService {

    private OkHttpClient client = new OkHttpClient();

    public String searchCocktails() {
        Request request = new Request.Builder()
                .url("https://the-cocktail-db.p.rapidapi.com/search.php?s=vodka")
                .get()
                .addHeader("X-RapidAPI-Key", "994a06b8f2mshbff0e95525f145fp1f054bjsn7eefc7c1bcf9")
                .addHeader("X-RapidAPI-Host", "the-cocktail-db.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string
                        ();
            } else {
                return "---실패---";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "에러내용: " + e.getMessage();
        }
    }


}
