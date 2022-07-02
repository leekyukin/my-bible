package com.project.mybible.bible.domain;

import com.project.mybible.user.domain.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "bible2")
public class Bible {

    @Id
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}

