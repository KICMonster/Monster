package com.monster.luvCocktail.domain.custom.entity;

import java.util.List;

import com.monster.luvCocktail.domain.member.entity.Member;
import com.monster.luvCocktail.domain.tag.entity.Tag;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CustomCocktail {
	
	@Id
	private Long id;
	
	private String title;
	private String description;
	private Long degree;
	
//	private List<Tag> tagList;
	
//	private Member creator;
}
