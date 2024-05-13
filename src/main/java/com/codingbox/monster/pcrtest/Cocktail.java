package com.codingbox.monster.pcrtest;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Cocktail {
    private int idDrink; // 칵테일 고유 ID
    private String strDrink; // 음료 이름
    private String strDrinkAlternate; // 대체 음료 이름
    private String strTags; // 음료 태그
    private String strVideo; // 음료 제작 비디오 링크
    private String strCategory; // 음료 카테고리
    private String strIBA; // 국제 바텐더 협회(I.B.A) 분류
    private String strAlcoholic; // 알코올 함유 여부
    private String strGlass; // 권장 잔
    private String strInstructions; // 조리 지침
    private String strInstructionsES; // 스페인어 조리 지침
    private String strInstructionsDE; // 독일어 조리 지침
    private String strInstructionsFR; // 프랑스어 조리 지침
    private String strInstructionsIT; // 이탈리아어 조리 지침
    private String strInstructionsZH; // 중국어 조리 지침
    private String strDrinkThumb; // 음료 이미지 URL
    private String strIngredient1; // 재료 1
    private String strIngredient2; // 재료 2
    private String strIngredient3; // 재료 3
    private String strIngredient4; // 재료 4
    private String strIngredient5; // 재료 5
    private String strIngredient6; // 재료 6
    private String strIngredient7; // 재료 7
    private String strIngredient8; // 재료 8
    private String strIngredient9; // 재료 9
    private String strIngredient10; // 재료 10
    private String strIngredient11; // 재료 11
    private String strIngredient12; // 재료 12
    private String strIngredient13; // 재료 13
    private String strIngredient14; // 재료 14
    private String strIngredient15; // 재료 15
    private String strMeasure1; // 양 1
    private String strMeasure2; // 양 2
    private String strMeasure3; // 양 3
    private String strMeasure4; // 양 4
    private String strMeasure5; // 양 5
    private String strMeasure6; // 양 6
    private String strMeasure7; // 양 7
    private String strMeasure8; // 양 8
    private String strMeasure9; // 양 9
    private String strMeasure10; // 양 10
    private String strMeasure11; // 양 11
    private String strMeasure12; // 양 12
    private String strMeasure13; // 양 13
    private String strMeasure14; // 양 14
    private String strMeasure15; // 양 15
    private String strImageSource; // 이미지 출처
    private String strImageAttribution; // 이미지 속성
    private String strCreativeCommonsConfirmed; // 크리에이티브 커먼즈 확인 여부

    private LocalDateTime dateModified; // 수정된 날짜
}
