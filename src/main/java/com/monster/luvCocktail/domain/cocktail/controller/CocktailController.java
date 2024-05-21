package com.monster.luvCocktail.domain.cocktail.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.monster.luvCocktail.domain.cocktail.dto.CocktailDTO;
import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailRequest;
import com.monster.luvCocktail.domain.cocktail.dto.CreateCocktailResponse;
import com.monster.luvCocktail.domain.cocktail.entity.Cocktail;
import com.monster.luvCocktail.domain.cocktail.service.CocktailService;
import com.monster.luvCocktail.global.config.api.ApiDefaultSetting;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cocktail")
public class CocktailController {

	private final CocktailService cocktailService;
	
    private final ApiDefaultSetting apiDefaultSetting;
    
//	// 기본 칵테일 생성
//	// 관리자 권한만 생성 가능
//	@PostMapping("")
//	@Operation(summary = "칵테일 생성하기", description = "칵테일을 생성합니다")
//	@ApiResponse(responseCode = "200", description = "통신 성공")
//	@ApiResponse(responseCode = "400", description = "파라미터 오류")
////	@Secured("ROLE_ADMIN") 
//	public ResponseEntity<CreateCocktailResponse> create(@RequestBody CreateCocktailRequest request) {
//		return ResponseEntity.ok(cocktailService.create(request));
//	}
//	
//	@GetMapping("")
//	public ResponseEntity<List<CocktailDTO>> getList() {
//		return ResponseEntity.ok(cocktailService.getList());
//	}
//	
//	// 커스텀 칵테일 생성
//	@PostMapping("/custom/new")
//	public ResponseEntity<CreateCocktailResponse> createCustom(@RequestBody CreateCocktailRequest request) {
//		return ResponseEntity.ok(cocktailService.create(request));
//	}
//	
//	@GetMapping("/{cocktailId}")
//	public ResponseEntity<CocktailDTO> viewDetail(@PathVariable Long cocktailId) {
//		return ResponseEntity.ok(cocktailService.viewDetail(cocktailId));
//	}
//
//	@GetMapping("/custom/{cocktailId}")
//	public ResponseEntity<CocktailDTO> viewCustomDetail(@PathVariable Long cocktailId) {
//		return ResponseEntity.ok(cocktailService.viewCustomDetail(cocktailId));
//	}
	

//----------------------------------------------------------------------------------------------------------

    @PostMapping("/save")
    public String saveCocktails(@RequestBody CocktailDTO cocktailDTO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        List<Cocktail> cocktails = createExampleData(cocktailDTO);

        cocktailService.saveCocktails(cocktails);

        return "저장성공";
    }

    private List<Cocktail> createExampleData(CocktailDTO cocktailDTO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Cocktail> cocktails = new ArrayList<>();
        JSONObject json = new JSONObject();

        for (int i = 0; i < 600; i++) {
            Cocktail cocktail = cocktailService.getResult(json);
            cocktails.add(cocktail);
        }

        return cocktails;
    }


    @GetMapping("/rawData")
    private ResponseEntity<JSONArray> getCocktailsList () {
        StringBuilder url = apiDefaultSetting.getUrlBuilder();
        String response = apiDefaultSetting.getResult(url);
        JSONArray obj = apiDefaultSetting.getResultJSON(response);
        return ResponseEntity.ok(obj);
    }
	
}
