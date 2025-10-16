package com.example.investing.domain.confirm.controller;

import com.example.investing.config.JwtUtil;
import com.example.investing.domain.common.annotation.Auth;
import com.example.investing.domain.common.dto.AuthUser;
import com.example.investing.domain.confirm.dto.request.ConfirmSaveRequest;
import com.example.investing.domain.confirm.dto.response.ConfirmResponse;
import com.example.investing.domain.confirm.service.ConfirmService;
import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConfirmController {

    private ConfirmService confirmService;
    private JwtUtil jwtUtil;

    @PostMapping("/invest/{investId}/confrims")
    public ResponseEntity<ConfirmResponse> saveConfirm(
            @Auth AuthUser authUser,
            @PathVariable Long investId,
            @Valid @RequestBody ConfirmSaveRequest request
    ) {
        return ResponseEntity.ok(confirmService.saveConfirm(authUser, investId, request));
    }

    @GetMapping("/invest/{investId}")
    public ResponseEntity<List<ConfirmResponse>> getConfirm(
            @PathVariable Long investId
    ) {
        return ResponseEntity.ok(confirmService.getConfirm(investId));
    }

    @DeleteMapping("/invest/{investId}/confirm/{comfirmId}")
    public void deleteConfirm(
            @RequestHeader("Authorization") String bearerToken,
            @PathVariable Long investId,
            @PathVariable Long confirmId
    ) {
        Claims claims = jwtUtil.extractClaims(bearerToken.substring(7));
        long userId = Long.parseLong(claims.getSubject());
        confirmService.deleteConfirm(userId,investId,confirmId);
    }
}
