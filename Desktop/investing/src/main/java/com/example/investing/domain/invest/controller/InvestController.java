package com.example.investing.domain.invest.controller;

import com.example.investing.domain.common.annotation.Auth;
import com.example.investing.domain.common.dto.AuthUser;
import com.example.investing.domain.invest.dto.request.InvestSaveRequest;
import com.example.investing.domain.invest.dto.response.InvestSaveResponse;
import com.example.investing.domain.invest.dto.response.InvetResponse;
import com.example.investing.domain.invest.service.InvestService;
import com.example.investing.domain.user.dto.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class InvestController {

     private InvestService investService;

     @PostMapping("/invests")
     public ResponseEntity<InvestSaveResponse> saveInvest(
             @Auth AuthUser authUser,
             @RequestBody InvestSaveRequest investSaveRequest
             ) {
         return ResponseEntity.ok(investService.saveInvest(investSaveRequest));
     }

     @GetMapping("/invests")
     public ResponseEntity<Page<InvetResponse>> getInvests(
           @RequestParam(defaultValue = "1") int pages,
           @RequestParam(defaultValue = "100") int sizes
     ) {
       return ResponseEntity.ok(investService.getInvests(pages, sizes));
     }

     @GetMapping("/invests/{investId}")
    public ResponseEntity<InvetResponse> getInvest(
            @PathVariable Long investId
     ) {
         return ResponseEntity.ok(investService.getInvest(investId));
     }



}
