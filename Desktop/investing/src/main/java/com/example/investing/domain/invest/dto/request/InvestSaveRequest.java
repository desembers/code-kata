package com.example.investing.domain.invest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvestSaveRequest {

    @NotBlank
    private String title;
    @NotBlank
    private String contents;
}
