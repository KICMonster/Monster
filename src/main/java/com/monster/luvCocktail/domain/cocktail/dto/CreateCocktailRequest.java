package com.monster.luvCocktail.domain.cocktail.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCocktailRequest {

	private String title;
	private String description;
	private Long degree;
}
