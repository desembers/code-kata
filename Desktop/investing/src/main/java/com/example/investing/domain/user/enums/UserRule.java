package com.example.investing.domain.user.enums;

import com.example.investing.domain.common.exception.InValidException;

import java.util.Arrays;

public enum UserRule {
    ADMIN, USER;

    public static UserRule of(String rule) {
        return Arrays.stream(UserRule.values())
                .filter(r -> r.name().equalsIgnoreCase(rule))
                .findFirst()
                .orElseThrow(() -> new InValidException("유요하지 않는 검증입니다."));
    }
}
