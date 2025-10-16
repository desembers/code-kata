package com.example.investing.domain.auth.dto;

import com.example.investing.domain.user.enums.UserRule;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignRequestDto {
    @NotBlank @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private UserRule userRule;
}
