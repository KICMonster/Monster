package com.monster.luvCocktail.domain.custom.service;

import com.monster.luvCocktail.domain.custom.dto.CreateCustomCocktailRequest;
import com.monster.luvCocktail.domain.custom.dto.CreateCustomCocktailResponse;

public interface CustomService {

	CreateCustomCocktailResponse create(CreateCustomCocktailRequest request);

}
