package com.codingbox.monster.service;

import com.codingbox.monster.ApiConfig;
import com.codingbox.monster.ApiDefaultSetting;
import com.codingbox.monster.entity.Cocktail;
import com.codingbox.monster.repository.CocktailRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CocktailService {
    @Autowired
    private CocktailRepository cocktailRepository;

    private final ApiConfig apiConfig;

    public void saveCocktails(List<Cocktail> cocktails) {
        cocktailRepository.saveAll(cocktails);
    }

    public String searchCocktails() {
        StringBuilder urlBuilder = new ApiDefaultSetting(apiConfig).getUrlBuilder();
        return new ApiDefaultSetting(apiConfig).getResult(urlBuilder);
    }

    public Cocktail getResult(JSONObject obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Long idDrink = obj.getLong("idDrink");
        String strDrink = obj.getString("strDrink");
        String strDrinkAlternate = obj.optString("strDrinkAlternate");
        String strTags = obj.optString("strTags");
        String strVideo = obj.optString("strVideo");
        String strCategory = obj.optString("strCategory");
        String strIBA = obj.optString("strIBA");
        String strAlcoholic = obj.optString("strAlcoholic");
        String strGlass = obj.optString("strGlass");
        String strInstructions = obj.optString("strInstructions");
        String strDrinkThumb = obj.optString("strDrinkThumb");
        String strImageSource = obj.optString("strImageSource");
        String strImageAttribution = obj.optString("strImageAttribution");
        String strCreativeCommonsConfirmed = obj.optString("strCreativeCommonsConfirmed");
        LocalDateTime dateModified = LocalDateTime.parse(obj.optString("dateModified"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Cocktail cocktail = new Cocktail();
        cocktail.setIdDrink(idDrink);
        cocktail.setStrDrink(strDrink);
        cocktail.setStrDrinkAlternate(strDrinkAlternate);
        cocktail.setStrTags(strTags);
        cocktail.setStrVideo(strVideo);
        cocktail.setStrCategory(strCategory);
        cocktail.setStrIBA(strIBA);
        cocktail.setStrAlcoholic(strAlcoholic);
        cocktail.setStrGlass(strGlass);
        cocktail.setStrInstructions(strInstructions);
        cocktail.setStrDrinkThumb(strDrinkThumb);
        cocktail.setStrImageSource(strImageSource);
        cocktail.setStrImageAttribution(strImageAttribution);
        cocktail.setStrCreativeCommonsConfirmed(strCreativeCommonsConfirmed);
        cocktail.setDateModified(dateModified);

        for (int i = 1; i <= 15; i++) {
            String ingredientKey = "strIngredient" + i;
            String ingredient = obj.optString(ingredientKey);
            Method ingredientSetter = Cocktail.class.getDeclaredMethod("setStrIngredient" + i, String.class);
            ingredientSetter.invoke(cocktail, ingredient);
        }

        for (int i = 1; i <= 15; i++) {
            String measureKey = "strMeasure" + i;
            String measure = obj.optString(measureKey);
            Method measureSetter = Cocktail.class.getDeclaredMethod("setStrMeasure" + i, String.class);
            measureSetter.invoke(cocktail, measure);
        }

        return cocktail;
    }
}
