package com.example.investing.domain.user.controller;

import com.example.investing.domain.user.dto.request.UserRuleChangeRequest;
import com.example.investing.domain.user.service.UserAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserAdminController {

    private final UserAdminService userAdminService;

    @PatchMapping("/admin/invest/{userId}")
    public void changeUserRule(@PathVariable Long userId, @RequestBody UserRuleChangeRequest userRuleChangeRequest) {
        userAdminService.changeUserRule(userId, userRuleChangeRequest);
    }


}
