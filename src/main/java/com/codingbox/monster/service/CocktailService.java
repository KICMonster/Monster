package com.codingbox.monster.service;

import com.codingbox.monster.ApiConfig;
import com.codingbox.monster.ApiDefaultSetting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CocktailService {
    private final ApiConfig apiConfig;

    public String searchCocktails() {
        StringBuilder urlBuilder = new ApiDefaultSetting(apiConfig).getUrlBuilder();
        return  new ApiDefaultSetting(apiConfig).getResult(urlBuilder);
    }
}
