package com.example.investing.domain.user.controller;

import com.example.investing.domain.common.annotation.Auth;
import com.example.investing.domain.common.dto.AuthUser;
import com.example.investing.domain.user.dto.request.UserChangePassword;
import com.example.investing.domain.user.dto.response.UserResponse;
import com.example.investing.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @GetMapping("/invest/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUsers(userId));
    }

    @PutMapping("/invest")
    public void chagnePassword(@Auth AuthUser authUser, @RequestBody UserChangePassword userChangePassword) {
        userService.chagnePasswords(authUser.getId(), userChangePassword);
    }

}
