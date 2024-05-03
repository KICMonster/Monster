package com.monster.luvCocktail.domain.custom.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monster.luvCocktail.domain.custom.dto.CreateCustomCocktailRequest;
import com.monster.luvCocktail.domain.custom.dto.CreateCustomCocktailResponse;
import com.monster.luvCocktail.domain.custom.entity.CustomCocktail;
import com.monster.luvCocktail.domain.custom.repository.CustomRepository;
import com.monster.luvCocktail.domain.member.entity.Member;
import com.monster.luvCocktail.global.SessionConst;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomServiceImpl implements CustomService{
	private final CustomRepository customRepository;
	private final HttpSession session;
	
	
	@Override
	@Transactional 
	public CreateCustomCocktailResponse create(CreateCustomCocktailRequest request) {
		
		// creator 찾기 
		Member creator = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
		
		if (creator == null) {
			throw new IllegalStateException("로그인이 필요합니다");
		} else {
		// 로그인이 된 경우 실행	
		
		// 새로운 CustomCocktail 객체 만들기
		CustomCocktail customCocktail = new CustomCocktail();
		
		// mapping 하기
		customCocktail.setTitle(request.getTitle());
		customCocktail.setDescription(request.getDescription());
		customCocktail.setDegree(request.getDegree());
		
		// DB에 저장하기
		customRepository.save(customCocktail);
		
		// 새로운 response 객체 만들기
		CreateCustomCocktailResponse response = new CreateCustomCocktailResponse();
		
		// response 에 mapping 하기
		response.setTitle(customCocktail.getTitle());
		response.setDescription(customCocktail.getDescription());
		response.setDegree(customCocktail.getDegree());

		// response 반환하기
		return response;
		}
	}

}
