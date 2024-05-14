package com.monster.luvCocktail.domain.cocktail.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.monster.luvCocktail.domain.cocktail.dto.CocktailDTO;
import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailRequest;
import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailResponse;
import com.monster.luvCocktail.domain.cocktail.entity.Cocktail;
import com.monster.luvCocktail.domain.cocktail.repository.CocktailRepository;
import com.monster.luvCocktail.domain.member.entity.Member;
import com.monster.luvCocktail.global.SessionConst;
import com.monster.luvCocktail.global.exception.ErrorCode;
import com.monster.luvCocktail.global.exception.ServiceException;

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

	@Override
	public CocktailDTO viewDetail(Long cocktailId) {
		Cocktail cocktail = cocktailRepository.findById(cocktailId).orElseThrow(() -> new ServiceException(ErrorCode.COCKTAIL_NOT_FOUND));
		CocktailDTO response = new CocktailDTO();
		response.setTitle(cocktail.getTitle());
		response.setDescription(cocktail.getDescription());
		response.setImage(cocktail.getImage());
		response.setDegree(cocktail.getDegree());
		return response;
	}

	@Override
	public CocktailDTO viewCustomDetail(Long cocktailId) {
		Cocktail cocktail = cocktailRepository.findById(cocktailId).orElseThrow(() -> new ServiceException(ErrorCode.COCKTAIL_NOT_FOUND));
		CocktailDTO response = new CocktailDTO();
		response.setTitle(cocktail.getTitle());
		response.setDescription(cocktail.getDescription());
		response.setImage(cocktail.getImage());
		response.setDegree(cocktail.getDegree());
		response.setCustom(true);
		response.setCreatorName(cocktail.getCreator().getName());
		return response;
	}

    @Override
    public List<CocktailDTO> getList() {
        // 칵테일 엔티티 리스트를 가져온다
        List<Cocktail> cocktails = cocktailRepository.findAll();

        // 칵테일 엔티티 리스트를 CocktailDTO 리스트로 변환한다
        return cocktails.stream().map(cocktail -> {
            CocktailDTO dto = new CocktailDTO();
            dto.setTitle(cocktail.getTitle());
            dto.setDescription(cocktail.getDescription());
            dto.setDegree(cocktail.getDegree());
            dto.setImage(cocktail.getImage());
            dto.setCustom(cocktail.isCustom());
            if (cocktail.getCreator() != null) {
                dto.setCreatorName(cocktail.getCreator().getName());
            }
            // 여기에서 추가적인 필드를 설정할 수 있습니다
            return dto;
        }).collect(Collectors.toList());
    }

}
