package com.monster.luvCocktail.domain.member.dto;

public class SingleResponseDTO<T> {
    private T data;

    public SingleResponseDTO(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}