package com.monster.luvCocktail.domain.custom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monster.luvCocktail.domain.custom.entity.CustomCocktail;

public interface CustomRepository extends JpaRepository<CustomCocktail, Long> {

}
