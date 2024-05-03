package com.monster.luvCocktail.domain.cocktail.dto;

import lombok.Getter;

@Getter
public class CreateCocktailRequest {

	private String title;
	private String description;
	private Long degree;
}
