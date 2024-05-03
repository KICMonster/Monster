package com.monster.luvCocktail.domain.cocktail.entity;

import com.monster.luvCocktail.domain.ingredient.entity.Ingredient;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 다대다 관계를 위한 연결 엔티티
@Getter
@Setter
@NoArgsConstructor
@Entity
public class CocktailAndIngredients {

	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="cocktail_id")
	private Cocktail cocktail;
	
	@ManyToOne
	@JoinColumn(name="ingredient_id")
	private Ingredient ingredient;
	
}
