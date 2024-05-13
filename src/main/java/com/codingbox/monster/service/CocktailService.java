package com.codingbox.monster.service;

import com.codingbox.monster.entity.Cocktail;
import com.codingbox.monster.repository.CocktailRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CocktailService {

    private final CocktailRepository cocktailRepository;

    public CocktailService(CocktailRepository cocktailRepository) {
        this.cocktailRepository = cocktailRepository;
    }

    // 비동기로 칵테일 데이터 저장
    @Async
    public void saveCocktailDataAsync(String responseData) {
        Cocktail cocktail = new Cocktail();
        cocktail.setStrDrink(responseData); // 또는 다른 적절한 필드를 사용
        cocktailRepository.save(cocktail);
    }
}
