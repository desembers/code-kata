package com.example.investing.domain.user.dto.response;

import lombok.Getter;

@Getter
public class UserSaveResponse {
     private final String bearerToekn;

     public UserSaveResponse(String bearerToekn) {
         this.bearerToekn = bearerToekn;
     }
}
