package com.monster.luvCocktail.domain.custom.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monster.luvCocktail.domain.custom.dto.CreateCustomCocktailRequest;
import com.monster.luvCocktail.domain.custom.dto.CreateCustomCocktailResponse;


@Service
@Transactional(readOnly = true)
public class CustomServiceImpl implements CustomService{

	@Override
	public CreateCustomCocktailResponse create(CreateCustomCocktailRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
