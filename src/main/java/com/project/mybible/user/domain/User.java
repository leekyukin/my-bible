package com.project.mybible.user.domain;

import com.project.mybible.bible.domain.Bible;
import com.project.mybible.golbal.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MySentence> myList = new ArrayList<>();

    @Builder
    User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
