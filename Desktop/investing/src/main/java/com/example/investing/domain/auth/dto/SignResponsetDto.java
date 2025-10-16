package com.example.investing.domain.auth.dto;

import lombok.Getter;

@Getter
public class SignResponsetDto {
    private String barerToken;

    public SignResponsetDto(String barerToken) {
        this.barerToken = barerToken;
    }
}
