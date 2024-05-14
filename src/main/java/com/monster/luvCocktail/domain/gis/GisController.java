package com.monster.luvCocktail.domain.gis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monster.luvCocktail.domain.gis.service.GisService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gis")
public class GisController {

	private final GisService gisService;

	// 기본 칵테일 생성
	// 관리자 권한만 생성 가능
	@GetMapping("/get")
	@Operation(summary = "칵테일 생성하기", description = "칵테일을 생성합니다")
	@ApiResponse(responseCode = "200", description = "통신 성공")
	@ApiResponse(responseCode = "400", description = "파라미터 오류")
	public ResponseEntity<SearchResponse> create(@RequestParam("latitude") double latitude,
			@RequestParam("longitude") double longitude) throws Exception {

		return gisService.getPlaceInfo(latitude, longitude);
	}
}
