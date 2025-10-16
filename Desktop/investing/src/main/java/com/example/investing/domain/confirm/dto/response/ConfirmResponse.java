package com.example.investing.domain.confirm.dto.response;

import com.example.investing.domain.user.entity.Users;
import lombok.Getter;

@Getter
public class ConfirmResponse {
    private Long id;
    private Users users;

    public ConfirmResponse(Long id, Users users) {
        this.id = id;
        this.users = users;
    }

}
