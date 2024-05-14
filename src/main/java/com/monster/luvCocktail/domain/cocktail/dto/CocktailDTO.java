package com.monster.luvCocktail.domain.cocktail.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CocktailDTO {

	private String title;
	private String description;
	private Long degree;
	private String image;
	private boolean isCustom;
	private String creatorName;
//	private List<E> 
}
