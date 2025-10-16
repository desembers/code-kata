package com.example.investing.domain.invest.entity;

import com.example.investing.domain.common.entity.BaseTime;
import com.example.investing.domain.confirm.entity.Confirm;
import com.example.investing.domain.user.entity.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "invest")
@NoArgsConstructor
@Getter
public class Invest extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;
    private String invest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;

    @OneToMany(mappedBy = "invest", cascade = CascadeType.REMOVE)
    private List<Text> condition = new ArrayList<>();

    @OneToMany(mappedBy = "invest", cascade = CascadeType.PERSIST)
    private List<Confirm> confirm = new ArrayList<>();

    public Invest(String title, String contents, String invest) {
        this.title = title;
        this.contents = contents;
        this.invest = invest;
        this.users = users;
        this.confirm.add(new Confirm(users, this));
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }


}
