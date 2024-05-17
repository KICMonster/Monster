package com.codingbox.monster.controller;

import com.codingbox.monster.ApiDefaultSetting;
import com.codingbox.monster.dto.CocktailDTO;
import com.codingbox.monster.entity.Cocktail;
import com.codingbox.monster.service.CocktailService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cocktail")
@RequiredArgsConstructor
public class CocktailController {

    @Autowired
    private final CocktailService cocktailService;

    @Autowired
    private final ApiDefaultSetting apiDefaultSetting;


    @PostMapping("/save")
    public String saveCocktails(@RequestBody CocktailDTO cocktailDTO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        List<Cocktail> cocktails = createExampleData(cocktailDTO, 100);

        cocktailService.saveCocktails(cocktails);

        return "저장성공";
    }

    private List<Cocktail> createExampleData(CocktailDTO cocktailDTO, Integer count) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Cocktail> cocktails = new ArrayList<>();
        JSONObject json = new org.json.JSONObject();

        for (int i = 0; i < count; i++) {
            Cocktail cocktail = cocktailService.getResult(json);
            cocktails.add(cocktail);
        }

        return cocktails;
    }


    @GetMapping("/rawData")
    private ResponseEntity<JSONArray> getCocktailsList () {
        StringBuilder url = apiDefaultSetting.getUrlBuilder();
        String response = apiDefaultSetting.getResult(url);
        JSONArray obj = apiDefaultSetting.getResultJSON(response);
        return ResponseEntity.ok(obj);
    }
}
