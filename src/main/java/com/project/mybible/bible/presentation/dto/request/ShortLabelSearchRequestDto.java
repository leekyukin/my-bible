package com.project.mybible.bible.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShortLabelSearchRequestDto {

    private String shortLabel;
    private int chapter;
    private int paragraph;
}
