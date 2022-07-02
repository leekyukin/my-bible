package com.project.mybible.bible.service;

import com.project.mybible.bible.domain.Bible;
import com.project.mybible.bible.facade.BibleFacade;
import com.project.mybible.bible.presentation.dto.request.RangeSearchRequestDto;
import com.project.mybible.bible.presentation.dto.request.ShortLabelSearchRequestDto;
import com.project.mybible.bible.presentation.dto.response.ChapterResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BibleService {

    private final BibleFacade bibleFacade;

    public List<ChapterResponseDto> getChapter(ShortLabelSearchRequestDto request) {
        List<Bible> bibles = bibleFacade.getChapter(request.getShortLabel(), request.getChapter());

        return bibles.stream()
                .map(ChapterResponseDto::of)
                .collect(Collectors.toList());
    }

    public ChapterResponseDto getSentence(ShortLabelSearchRequestDto request) {
        Bible bible = bibleFacade.getSentence(
                request.getShortLabel(),
                request.getChapter(),
                request.getParagraph()
        );

        return ChapterResponseDto.of(bible);
    }

    public List<ChapterResponseDto> getRange(RangeSearchRequestDto request) {
        List<Bible> bible = bibleFacade.getChapter(request.getShortLabel(), request.getChapter());

        return bible.stream()
                .dropWhile(b -> b.getParagraph() < request.getStartPara())
                .takeWhile(b -> b.getParagraph() <= request.getEndPara())
                .map(ChapterResponseDto::of)
                .collect(Collectors.toList());
    }
}
