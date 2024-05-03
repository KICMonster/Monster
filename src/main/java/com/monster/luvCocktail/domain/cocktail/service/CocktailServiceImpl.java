package com.monster.luvCocktail.domain.cocktail.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailRequest;
import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailResponse;
import com.monster.luvCocktail.domain.cocktail.dto.CreateCustomCocktailResponse;
import com.monster.luvCocktail.domain.cocktail.entity.Cocktail;
import com.monster.luvCocktail.domain.cocktail.repository.CocktailRepository;
import com.monster.luvCocktail.domain.member.entity.Member;
import com.monster.luvCocktail.global.SessionConst;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CocktailServiceImpl implements CocktailService{
	private final CocktailRepository cocktailRepository;
	private final HttpSession session;

	
	@Override		// 관리자 권한으로 칵테일 생성하기
	@Transactional
	public CreateCocktailResponse create(CreateCocktailRequest request) {

		// 새로운 CustomCocktail 객체 만들기
		Cocktail cocktail = new Cocktail();
		
		// mapping 하기
		cocktail.setTitle(request.getTitle());
		cocktail.setDescription(request.getDescription());
		cocktail.setDegree(request.getDegree());
		
		// DB에 저장하기
		cocktailRepository.save(cocktail);
		
		// 새로운 response 객체 만들기
		CreateCocktailResponse response = new CreateCocktailResponse();
		
		// response 에 mapping 하기
		response.setTitle(cocktail.getTitle());
		response.setDescription(cocktail.getDescription());
		response.setDegree(cocktail.getDegree());

		// response 반환하기
		return response;
	}

	@Override
	@Transactional
	public CreateCocktailResponse createCustom(CreateCocktailRequest request) {

		// creator 찾기 
		Member creator = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
		
		if (creator == null) {
			throw new IllegalStateException("로그인이 필요합니다");
		} else {
		// 로그인이 된 경우 실행	
		
		// 새로운 CustomCocktail 객체 만들기
		Cocktail cocktail = new Cocktail();
		
		// mapping 하기
		cocktail.setTitle(request.getTitle());
		cocktail.setDescription(request.getDescription());
		cocktail.setDegree(request.getDegree());
		cocktail.setCreator(creator);
		cocktail.setCustom(true);
		
		// DB에 저장하기
		cocktailRepository.save(cocktail);
		
		// 새로운 response 객체 만들기
		CreateCocktailResponse response = new CreateCocktailResponse();
		
		// response 에 mapping 하기
		response.setTitle(cocktail.getTitle());
		response.setDescription(cocktail.getDescription());
		response.setDegree(cocktail.getDegree());
		response.setCustom(true);
		response.setCreatorName(creator.getName());
		// response 반환하기
		return response;
		}
	}

}
