package com.example.investing.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserChangePassword {
      @NotBlank
      private String PastPassword;

      @NotBlank
      private String NowPassword;
}
