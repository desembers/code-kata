package com.example.investing.domain.user.entity;

import com.example.investing.domain.common.dto.AuthUser;
import com.example.investing.domain.common.entity.BaseTime;
import com.example.investing.domain.user.enums.UserRule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
public class Users extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRule userRule;

    public Users(String email, String password, UserRule userRule) {
        this.email = email;
        this.password = password;
        this.userRule = userRule;
    }

    private Users(Long id, String email, UserRule userRule) {
        this.id = id;
        this.email = email;
        this.userRule = userRule;
    }


    public static Users fromAuthUsers(AuthUser authUser) {
        return new Users(authUser.getId(), authUser.getEmail(), authUser.getUserRule());
    }

    public void changePasswords(String password) {
        this.password = password;
    }

    public void UpdateRule(UserRule userRule) {
        this.userRule = userRule;
    }

}
