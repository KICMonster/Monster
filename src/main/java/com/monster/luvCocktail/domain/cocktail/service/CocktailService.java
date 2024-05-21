package com.monster.luvCocktail.domain.cocktail.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.monster.luvCocktail.domain.cocktail.dto.CocktailDTO;
import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailRequest;
import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailResponse;
import com.monster.luvCocktail.domain.cocktail.entity.Cocktail;
import com.monster.luvCocktail.domain.cocktail.repository.CocktailRepository;
import com.monster.luvCocktail.domain.member.entity.Member;
import com.monster.luvCocktail.global.SessionConst;
import com.monster.luvCocktail.global.config.api.ApiConfig;
import com.monster.luvCocktail.global.config.api.ApiDefaultSetting;
import com.monster.luvCocktail.global.exception.ErrorCode;
import com.monster.luvCocktail.global.exception.ServiceException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class CocktailService {
    @Autowired
    private CocktailRepository cocktailRepository;

    private final ApiConfig apiConfig;

    @Value("${rapid.api.key}")
    private String apiKey;
    @Value("${rapid.api.requestURI}")
    private String apirequestURI;
    @Value("${rapid.api.host}")
    private String apihost;

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
        cocktail.setStrCategory(strCategory);
        cocktail.setStrAlcoholic(strAlcoholic);
        cocktail.setStrGlass(strGlass);
        cocktail.setStrInstructions(strInstructions);
        cocktail.setStrDrinkThumb(strDrinkThumb);
        cocktail.setStrCreativeCommonsConfirmed(strCreativeCommonsConfirmed);

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

    public List<Cocktail> getListFromAPI() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(apirequestURI)
                .get()
                .addHeader("X-RapidAPI-Key", apiKey)
                .addHeader("X-RapidAPI-Host", apihost)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                System.out.println(response.body().string());
            } else {
                System.out.println("Request not successful: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return List.of();
    }
}