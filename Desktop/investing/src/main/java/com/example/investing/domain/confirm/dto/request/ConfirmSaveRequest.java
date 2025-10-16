package com.example.investing.domain.confirm.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ConfirmSaveRequest {
    @NotNull
    private Long ConfirmuserId;
}
