package com.codingbox.monster.service;

import com.codingbox.monster.ApiDefaultSetting;
import com.codingbox.monster.entity.Cocktail;
import com.codingbox.monster.repository.CocktailRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CocktailService {

    @Autowired
    private CocktailRepository cocktailRepository;

    private final ApiDefaultSetting apiDefaultSetting;

    public void saveCocktails(List<Cocktail> cocktails) {
        cocktailRepository.saveAll(cocktails);
    }

    public List<Cocktail> fetchAllCocktailsFromApi() throws ParseException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Cocktail> allCocktails = new ArrayList<>();
        boolean moreData = true;
        int offset = 0;
        int limit = 2;

        while (moreData) {
            StringBuilder url = apiDefaultSetting.getUrlBuilder();
            url.append("&offset=").append(offset).append("&limit=").append(limit);
            String response = apiDefaultSetting.getResult(url);
            JSONArray jsonArray = getJsonArrayFromResponse(response);

            if (jsonArray.isEmpty()) {
                moreData = false;
            } else {
                List<Cocktail> cocktails = convertJsonArrayToCocktails(jsonArray);
                allCocktails.addAll(cocktails);
                offset += jsonArray.size();
            }
        }

        return allCocktails;
    }

    private JSONArray getJsonArrayFromResponse(String response) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response);
        return (JSONArray) jsonObject.get("drinks");
    }

    private List<Cocktail> convertJsonArrayToCocktails(JSONArray jsonArray) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Cocktail> cocktails = new ArrayList<>();
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            Cocktail cocktail = convertJsonToCocktail(jsonObject);
            cocktails.add(cocktail);
        }
        return cocktails;
    }

    private Cocktail convertJsonToCocktail(JSONObject jsonObject) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Long idDrink = Long.valueOf((String) jsonObject.get("idDrink"));
        String strDrink = (String) jsonObject.get("strDrink");
        String strDrinkAlternate = (String) jsonObject.get("strDrinkAlternate");
        String strTags = (String) jsonObject.get("strTags");
        String strVideo = (String) jsonObject.get("strVideo");
        String strCategory = (String) jsonObject.get("strCategory");
        String strIBA = (String) jsonObject.get("strIBA");
        String strAlcoholic = (String) jsonObject.get("strAlcoholic");
        String strGlass = (String) jsonObject.get("strGlass");
        String strInstructions = (String) jsonObject.get("strInstructions");
        String strDrinkThumb = (String) jsonObject.get("strDrinkThumb");
        String strImageSource = (String) jsonObject.get("strImageSource");
        String strImageAttribution = (String) jsonObject.get("strImageAttribution");
        String strCreativeCommonsConfirmed = (String) jsonObject.get("strCreativeCommonsConfirmed");

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

        for (int i = 1; i <= 15; i++) {
            String ingredientKey = "strIngredient" + i;
            String ingredient = (String) jsonObject.get(ingredientKey);
            if (ingredient != null) {
                Method ingredientSetter = Cocktail.class.getDeclaredMethod("setStrIngredient" + i, String.class);
                ingredientSetter.invoke(cocktail, ingredient);
            }
        }

        for (int i = 1; i <= 15; i++) {
            String measureKey = "strMeasure" + i;
            String measure = (String) jsonObject.get(measureKey);
            if (measure != null) {
                Method measureSetter = Cocktail.class.getDeclaredMethod("setStrMeasure" + i, String.class);
                measureSetter.invoke(cocktail, measure);
            }
        }

        return cocktail;
    }
}
