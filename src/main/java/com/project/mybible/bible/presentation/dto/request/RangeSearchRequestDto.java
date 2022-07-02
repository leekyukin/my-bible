package com.project.mybible.bible.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RangeSearchRequestDto {

    private String shortLabel;
    private int chapter;
    private int startPara;
    private int endPara;
}
