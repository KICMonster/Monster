package com.monster.luvCocktail.domain.cocktail.dto;

import lombok.Setter;

@Setter
public class CreateCocktailResponse {
	private String title;
	private String description;
	private Long degree;
	private String creatorName;
	private boolean isCustom = false;
}
