package com.monster.luvCocktail.domain.custom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.monster.luvCocktail.domain.custom.dto.CreateCustomCocktailRequest;
import com.monster.luvCocktail.domain.custom.dto.CreateCustomCocktailResponse;
import com.monster.luvCocktail.domain.custom.service.CustomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/custom")
public class CustomController {

	private final CustomService customService;
	
	// 이런식으로 처리하시면 됩니다 ( 에러처리는 서비스에서 할지 컨트롤러에서 할지 같이 의논을 해봐야할것 같네요 )
	@PostMapping("/new")
	public ResponseEntity<CreateCustomCocktailResponse> create(@RequestBody CreateCustomCocktailRequest request) {
		return ResponseEntity.ok(customService.create(request));
	}
	
}














	