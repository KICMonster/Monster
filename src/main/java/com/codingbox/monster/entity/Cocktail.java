package com.codingbox.monster.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDrink;

    private String strDrink;
    private String strCategory;
    private String strAlcoholic;
    private String strGlass;
    private String strInstructions;
    private String strDrinkThumb;
    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;
    private String strIngredient8;
    private String strIngredient9;
    private String strIngredient10;
    private String strIngredient11;
    private String strIngredient12;
    private String strIngredient13;
    private String strIngredient14;
    private String strIngredient15;
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;
    private String strCreativeCommonsConfirmed;
    private String strRecommend;

    // 기본 생성자
    public Cocktail() {}

    // 전체 필드를 포함하는 생성자
    public Cocktail(Long idDrink, String strDrink, String strCategory, String strAlcoholic, String strGlass, String strInstructions, String strDrinkThumb, String strIngredient1, String strIngredient2, String strIngredient3, String strIngredient4, String strIngredient5, String strIngredient6, String strIngredient7, String strIngredient8, String strIngredient9, String strIngredient10, String strIngredient11, String strIngredient12, String strIngredient13, String strIngredient14, String strIngredient15, String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4, String strMeasure5, String strMeasure6, String strMeasure7, String strMeasure8, String strMeasure9, String strMeasure10, String strMeasure11, String strMeasure12, String strMeasure13, String strMeasure14, String strMeasure15, String strCreativeCommonsConfirmed, String strRecommend) {
        this.idDrink = idDrink;  // 칵테일의 고유 ID
        this.strDrink = strDrink;  // 칵테일 이름
        this.strCategory = strCategory;  // 칵테일 카테고리
        this.strAlcoholic = strAlcoholic;  // 알코올 여부 (Alcoholic, Non_Alcoholic)
        this.strGlass = strGlass;  // 사용되는 글라스 종류
        this.strInstructions = strInstructions;  // 칵테일 제조법
        this.strDrinkThumb = strDrinkThumb;  // 칵테일 이미지 URL
        this.strIngredient1 = strIngredient1;  // 첫 번째 재료 (있을 경우)
        this.strIngredient2 = strIngredient2;  // 두 번째 재료 (있을 경우)
        this.strIngredient3 = strIngredient3;  // 세 번째 재료 (있을 경우)
        this.strIngredient4 = strIngredient4;  // 네 번째 재료 (있을 경우)
        this.strIngredient5 = strIngredient5;  // 다섯 번째 재료 (있을 경우)
        this.strIngredient6 = strIngredient6;  // 여섯 번째 재료 (있을 경우)
        this.strIngredient7 = strIngredient7;  // 일곱 번째 재료 (있을 경우)
        this.strIngredient8 = strIngredient8;  // 여덟 번째 재료 (있을 경우)
        this.strIngredient9 = strIngredient9;  // 아홉 번째 재료 (있을 경우)
        this.strIngredient10 = strIngredient10;  // 열 번째 재료 (있을 경우)
        this.strIngredient11 = strIngredient11;  // 열한 번째 재료 (있을 경우)
        this.strIngredient12 = strIngredient12;  // 열두 번째 재료 (있을 경우)
        this.strIngredient13 = strIngredient13;  // 열세 번째 재료 (있을 경우)
        this.strIngredient14 = strIngredient14;  // 열네 번째 재료 (있을 경우)
        this.strIngredient15 = strIngredient15;  // 열다섯 번째 재료 (있을 경우)
        this.strMeasure1 = strMeasure1;  // 첫 번째 재료의 측정값 (있을 경우)
        this.strMeasure2 = strMeasure2;  // 두 번째 재료의 측정값 (있을 경우)
        this.strMeasure3 = strMeasure3;  // 세 번째 재료의 측정값 (있을 경우)
        this.strMeasure4 = strMeasure4;  // 네 번째 재료의 측정값 (있을 경우)
        this.strMeasure5 = strMeasure5;  // 다섯 번째 재료의 측정값 (있을 경우)
        this.strMeasure6 = strMeasure6;  // 여섯 번째 재료의 측정값 (있을 경우)
        this.strMeasure7 = strMeasure7;  // 일곱 번째 재료의 측정값 (있을 경우)
        this.strMeasure8 = strMeasure8;  // 여덟 번째 재료의 측정값 (있을 경우)
        this.strMeasure9 = strMeasure9;  // 아홉 번째 재료의 측정값 (있을 경우)
        this.strMeasure10 = strMeasure10;  // 열 번째 재료의 측정값 (있을 경우)
        this.strMeasure11 = strMeasure11;  // 열한 번째 재료의 측정값 (있을 경우)
        this.strMeasure12 = strMeasure12;  // 열두 번째 재료의 측정값 (있을 경우)
        this.strMeasure13 = strMeasure13;  // 열세 번째 재료의 측정값 (있을 경우)
        this.strMeasure14 = strMeasure14;  // 열네 번째 재료의 측정값 (있을 경우)
        this.strMeasure15 = strMeasure15;  // 열다섯 번째 재료의 측정값 (있을 경우)
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;  // 크리에이티브 커먼즈 확인 여부 (있을 경우)
        this.strRecommend = strRecommend;

    }
}
