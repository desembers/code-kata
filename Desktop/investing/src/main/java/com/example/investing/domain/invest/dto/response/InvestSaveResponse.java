package com.example.investing.domain.invest.dto.response;

import com.example.investing.domain.user.dto.response.UserResponse;
import lombok.Getter;

@Getter
public class InvestSaveResponse {
    private Long id;
    private String title;
    private String contents;
    private String invest;
    private UserResponse user;

    public InvestSaveResponse(Long id, String title, String contents, String invest, UserResponse user) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.invest = invest;
        this.user = user;
    }

}
