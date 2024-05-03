package com.monster.luvCocktail.domain.ingredient.entity;

import java.util.ArrayList;
import java.util.List;

import com.monster.luvCocktail.domain.cocktail.entity.Cocktail;
import com.monster.luvCocktail.domain.cocktail.entity.CocktailAndIngredients;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ingredient {

	@Id
	private Long id;
	
	private String name;
	private String description;
	private String degree;
	
	@OneToMany(mappedBy = "ingredient")
	private List<CocktailAndIngredients> cocktailList = new ArrayList<>();
	
}
