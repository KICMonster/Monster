package com.monster.luvCocktail.domain.member.entity;

import java.util.ArrayList;
import java.util.List;

import com.monster.luvCocktail.domain.cocktail.entity.Cocktail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
	@Column(name = "MER_ID")
	private Long id;
	
	
	@Column(name = "MER_NM")
	private String name;
	
	@Column(name = "Email")
	private String email;

	@Column(name = "MER_PW")
	private String pasword;
	
	@Column(name = "MB_YMD")
	private String birth;
	
	@Column(name = "MER_PH")
	private String phone;
	
	@Column(name = "MER_ROLE")
	private String role;

	@Column(name = "LOGIN_TYPE")
	private String loginType;
	
	@Column(name = "TOKEN_ID")
	private String tokenId;
	
	@Column(name = "MER_TASTE")
	private String taste;
	
	@Column(name = "SURVEY_RES")
	private String surveyResult;
	
	@Column(name = "WITHDRAWL_DATE")
	private String withdrawlDate;
	
//	// Member 가 만든 칵테일 목록 , Cocktail 의 creator 변수에 매핑
//	@OneToMany(mappedBy = "creator")
//	private List<Cocktail> cocktailList = new ArrayList<>();
}
