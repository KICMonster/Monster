package com.monster.luvCocktail.domain.cocktail.service;

import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailRequest;
import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailResponse;

public interface CocktailService {
	// 칵테일 생성하기
	CreateCocktailResponse create(CreateCocktailRequest request);
	
	CreateCocktailResponse createCustom(CreateCocktailRequest request);
}
