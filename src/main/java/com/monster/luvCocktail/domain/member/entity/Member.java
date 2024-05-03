package com.monster.luvCocktail.domain.member.entity;

import java.util.ArrayList;
import java.util.List;

import com.monster.luvCocktail.domain.cocktail.entity.Cocktail;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "member")
public class Member {

	@Id
	private Long id;
	
	private String name;
	
	// Member 가 만든 칵테일 목록 , Cocktail 의 creator 변수에 매핑
	@OneToMany(mappedBy = "creator")
	private List<Cocktail> cocktailList = new ArrayList<>();
}
