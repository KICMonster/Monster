package com.monster.luvCocktail.domain.cocktail.service;

import java.util.List;

import com.monster.luvCocktail.domain.cocktail.dto.CocktailDTO;
import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailRequest;
import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailResponse;

public interface CocktailService {
	// 칵테일 생성하기
	CreateCocktailResponse create(CreateCocktailRequest request);
	
	CreateCocktailResponse createCustom(CreateCocktailRequest request);
	
	CocktailDTO viewDetail(Long cocktailId);
	
	CocktailDTO viewCustomDetail(Long cocktailId);

	List<CocktailDTO> getList();
	
}
