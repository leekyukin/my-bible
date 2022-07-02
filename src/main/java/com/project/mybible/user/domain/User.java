package com.project.mybible.user.domain;

import com.project.mybible.bible.domain.Bible;
import com.project.mybible.golbal.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Bible> myList = new ArrayList<>();

    public List<Bible> getMyList() {
        return myList;
    }

    @Builder
    User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
