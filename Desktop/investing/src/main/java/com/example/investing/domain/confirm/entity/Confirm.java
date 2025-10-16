package com.example.investing.domain.confirm.entity;

import com.example.investing.domain.invest.entity.Invest;
import com.example.investing.domain.user.entity.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "confirm")
public class Confirm {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invest_id", nullable = false)
    private Invest invest;

    public Confirm(Users users, Invest invest) {
        this.users = users;
        this.invest = invest;
    }



}
