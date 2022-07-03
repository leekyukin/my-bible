package com.project.mybible.bible.domain;

import com.project.mybible.user.domain.MySentence;
import com.project.mybible.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "bible2")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bible {

    @Id
    @Column(name = "bible_id")
    private Long idx;

    private int cate; // 구/신약 ( 1, 2 )
    private int book; // 책 (숫자 1 ~ 66)
    private int chapter; // 장
    private int paragraph; // 절
    private String sentence; // 문장
    private char testament; // 구/신약 ('구', '신')

    @Column(name = "long_label")
    private String longLabel; // 책 ("창세기", "출에굽기")

    @Column(name = "short_label")
    private String shortLabel; // 책 ("창", "출")

    @OneToMany(mappedBy = "bible", cascade = CascadeType.ALL)
    private List<MySentence> mySentences = new ArrayList<>();

}

