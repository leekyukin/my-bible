package com.project.mybible.bible.presentation.dto.response;

import com.project.mybible.bible.domain.Bible;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BibleResponseDto {

    private String longLabel;
    private int chapter;
    private int paragraph;
    private String sentence;

    public static BibleResponseDto of (Bible bible) {
        return BibleResponseDto.builder()
                .longLabel(bible.getLongLabel())
                .chapter(bible.getChapter())
                .paragraph(bible.getParagraph())
                .sentence(bible.getSentence())
                .build();
    }

}
