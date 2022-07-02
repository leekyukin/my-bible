package com.project.mybible.bible.presentation;

import com.project.mybible.bible.presentation.dto.request.RangeSearchRequestDto;
import com.project.mybible.bible.presentation.dto.request.ShortLabelSearchRequestDto;
import com.project.mybible.bible.presentation.dto.response.ChapterResponseDto;
import com.project.mybible.bible.service.BibleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/bible")
@RequiredArgsConstructor
public class BibleController {

    private final BibleService bibleService;

    @GetMapping("/chapter")
    public List<ChapterResponseDto> getChapter(
            @RequestBody ShortLabelSearchRequestDto request
    ) {
        log.info(
                "url : {/bible/chapter}, short label : {}, chapter : {}",
                request.getShortLabel(),
                request.getChapter()
        );

        return bibleService.getChapter(request);
    }

    @GetMapping("/sentence")
    public ChapterResponseDto getSentence(
            @RequestBody ShortLabelSearchRequestDto request
    ) {
        log.info(
                "url : {/bible/sentence}, short label : {}, chapter : {}, paragraph : {}",
                request.getShortLabel(),
                request.getChapter(),
                request.getParagraph()
        );

        return bibleService.getSentence(request);
    }

    @GetMapping("/range")
    public List<ChapterResponseDto> getRange(
            @RequestBody RangeSearchRequestDto request
    ) {
        log.info(
                "url : {/bible/range}, label : {}, chapter : {}, start : {}, end : {}",
                request.getShortLabel(), request.getChapter(), request.getStartPara(), request.getEndPara()
        );

        return bibleService.getRange(request);
    }
}
