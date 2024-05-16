package com.codingbox.monster.controller;

import com.codingbox.monster.dto.CocktailDTO;
import com.codingbox.monster.entity.Cocktail;
import com.codingbox.monster.service.CocktailService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cocktail")
public class CocktailController {

    @Autowired
    private CocktailService cocktailService;

    @PostMapping("/save")
    public String saveCocktails(@RequestBody CocktailDTO cocktailDTO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 예제 데이터를 생성합니다.
        List<Cocktail> cocktails = createExampleData(cocktailDTO, 100);

        // 칵테일 데이터를 저장합니다.
        cocktailService.saveCocktails(cocktails);

        return "Saved 100 cocktails successfully!";
    }

    private List<Cocktail> createExampleData(CocktailDTO cocktailDTO, int count) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Cocktail> cocktails = new ArrayList<>();
        JSONObject json = new JSONObject(cocktailDTO);

        for (int i = 0; i < count; i++) {
            Cocktail cocktail = cocktailService.getResult(json);
            cocktails.add(cocktail);
        }

        return cocktails;
    }
}
