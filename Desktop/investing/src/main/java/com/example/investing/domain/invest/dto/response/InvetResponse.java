package com.example.investing.domain.invest.dto.response;

import com.example.investing.domain.user.dto.response.UserResponse;

import java.time.LocalDateTime;

public class InvetResponse {
    private Long id;
    private String title;
    private String contents;
    private String invest;
    private UserResponse user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public InvetResponse(Long id, String title, String contents, List<Text> invest, UserResponse user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.invest = invest;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
