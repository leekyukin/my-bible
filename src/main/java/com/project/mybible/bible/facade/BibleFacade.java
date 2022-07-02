package com.project.mybible.bible.facade;

import com.project.mybible.bible.domain.Bible;
import com.project.mybible.bible.domain.repository.BibleRepository;
import com.project.mybible.bible.exception.ChapterNotFoundException;
import com.project.mybible.bible.exception.SentenceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BibleFacade {

    private final BibleRepository bibleRepository;

    public List<Bible> getChapter(String shortLabel, int chapter) {
        return bibleRepository.findAllByShortLabelAndChapter(shortLabel, chapter)
                .orElseThrow(() -> ChapterNotFoundException.EXCEPTION);
    }

    public Bible getSentence(String shortLabel, int chapter, int paragraph) {
        return bibleRepository.findByShortLabelAndChapterAndParagraph(shortLabel, chapter, paragraph)
                .orElseThrow(() -> SentenceNotFoundException.EXCEPTION);
    }
}
