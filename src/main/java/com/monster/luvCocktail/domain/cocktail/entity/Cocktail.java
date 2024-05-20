package com.monster.luvCocktail.domain.cocktail.entity;


import java.util.ArrayList;
import java.util.List;

import com.monster.luvCocktail.domain.ingredient.entity.Ingredient;
import com.monster.luvCocktail.domain.member.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(
		name="Cocktail_SEQ_GENERATOR",
		sequenceName = "Cocktail_SEQ",
		initialValue = 1, allocationSize = 1
		)
public class Cocktail {

	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY,
			generator = "Cocktail_SEQ_GENERATOR"
			)
	@Column(name="cocktail_id")
	private Long id;
	private String title;
	private String description;
	private Long degree;
	private String image;
	private boolean isCustom;
	
	@ManyToOne
	@JoinColumn
	private Member creator;
	
	// 칵테일에 사용되는 재료 목록
	@OneToMany(mappedBy = "cocktail")
	private List<CocktailAndIngredients> ingredients = new ArrayList<>();
	
}
