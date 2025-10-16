package com.example.investing.domain.auth.controller;

import com.example.investing.domain.auth.dto.SignRequestDto;
import com.example.investing.domain.auth.dto.SignResponsetDto;
import com.example.investing.domain.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/signup")
    public SignResponsetDto signup(@Valid @RequestBody SignRequestDto requestDto) {
        return authService.signup(requestDto);
    }

    @PostMapping("/auth/logout")
    public SignResponsetDto logout(@Valid @RequestBody SignRequestDto requestDto) {
        return authService.logout(requestDto);
    }
}
