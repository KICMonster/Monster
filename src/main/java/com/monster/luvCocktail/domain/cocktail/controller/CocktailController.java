package com.monster.luvCocktail.domain.cocktail.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailRequest;
import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailResponse;
import com.monster.luvCocktail.domain.cocktail.service.CocktailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cocktail")
public class CocktailController {

	private final CocktailService cocktailService;
	
	// 기본 칵테일 생성
	// 관리자 권한만 생성 가능
	@PostMapping("/create")
	@Secured("ROLE_ADMIN") 
	public ResponseEntity<CreateCocktailResponse> create(@RequestBody CreateCocktailRequest request) {
		return ResponseEntity.ok(cocktailService.create(request));
	}
	
	// 커스텀 칵테일 생성
	@PostMapping("/custom")
	public ResponseEntity<CreateCocktailResponse> createCustom(@RequestBody CreateCocktailRequest request) {
		return ResponseEntity.ok(cocktailService.create(request));
	}
}
