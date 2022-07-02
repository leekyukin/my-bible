package com.project.mybible.bible.presentation.dto.response;

import com.project.mybible.bible.domain.Bible;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChapterResponseDto {

    private String longLabel;
    private int chapter;
    private int paragraph;
    private String sentence;

    public static ChapterResponseDto of (Bible bible) {
        return ChapterResponseDto.builder()
                .longLabel(bible.getLongLabel())
                .chapter(bible.getChapter())
                .paragraph(bible.getParagraph())
                .sentence(bible.getSentence())
                .build();
    }

}
