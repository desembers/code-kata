package com.example.investing.domain.common.dto;

import com.example.investing.domain.user.enums.UserRule;
import lombok.Getter;

@Getter
public class AuthUser {
    private final Long id;
    private final String email;
    private final UserRule userRule;

    public AuthUser(Long id, String email, UserRule userRule) {
        this.id = id;
        this.email = email;
        this.userRule = userRule;
    }

}
