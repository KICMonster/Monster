package com.codingbox.monster.controller;

import lombok.val;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@RequestMapping("/cocktails")
class CocktailController {

    @GetMapping("/search")
    fun searchCocktails(): String {
        val client = OkHttpClient()

        val request = Request.Builder()
                .url("https://the-cocktail-db.p.rapidapi.com/search.php?s=vodka")
                .get()
                .addHeader("X-RapidAPI-Key", "994a06b8f2mshbff0e95525f145fp1f054bjsn7eefc7c1bcf9")
                .addHeader("X-RapidAPI-Host", "the-cocktail-db.p.rapidapi.com")
                .build()

        try {
            val response: Response = client.newCall(request).execute()
            return response.body()?.string() ?: "No response"
        } catch (e: IOException) {
            e.printStackTrace()
            return "Error: ${e.message}"
        }
    }
}
