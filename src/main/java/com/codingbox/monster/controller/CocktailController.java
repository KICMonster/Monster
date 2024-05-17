package com.codingbox.monster.controller;

import com.codingbox.monster.ApiDefaultSetting;
import com.codingbox.monster.dto.CocktailDTO;
import com.codingbox.monster.entity.Cocktail;
import com.codingbox.monster.service.CocktailService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
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
    public String saveCocktails() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ParseException, ParseException {
        List<Cocktail> cocktails = cocktailService.fetchCocktailsFromApi();
        cocktailService.saveCocktails(cocktails);
        return "저장성공";
    }


    @GetMapping("/rawData")
    private ResponseEntity<JSONArray> getCocktailsList () {
        StringBuilder url = apiDefaultSetting.getUrlBuilder();
        String response = apiDefaultSetting.getResult(url);
        JSONArray obj = apiDefaultSetting.getResultJSON(response);
        return ResponseEntity.ok(obj);
    }
}
