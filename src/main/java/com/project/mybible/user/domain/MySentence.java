package com.project.mybible.user.domain;

import com.project.mybible.bible.domain.Bible;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "my_sentence")
public class MySentence {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_sentence_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bible_id")
    private Bible bible;

    @Builder
    public MySentence(User user, Bible bible) {
        this.user = user;
        this.bible = bible;
    }

    public static MySentence of(User user, Bible bible) {
        return MySentence.builder()
                .user(user)
                .bible(bible)
                .build();
    }

    public static MySentence setMyList(User user, Bible bible) {
        MySentence sentence = MySentence.of(user, bible);
        user.getMyList().add(sentence);
        bible.getMySentences().add(sentence);
        return sentence;
    }

}
