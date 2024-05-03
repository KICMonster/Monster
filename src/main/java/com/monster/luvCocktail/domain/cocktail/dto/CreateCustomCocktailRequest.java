package com.monster.luvCocktail.domain.cocktail.dto;

import lombok.Getter;

@Getter
public class CreateCustomCocktailRequest {

	private String title;
	private String description;
	private Long degree;
//	private List<Ingredient> ingredients;
}
