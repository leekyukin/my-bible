package com.project.mybible.user.presentation;

import com.project.mybible.bible.presentation.dto.request.ShortLabelSearchRequestDto;
import com.project.mybible.bible.presentation.dto.response.BibleResponseDto;
import com.project.mybible.user.presentation.dto.request.CreateUserRequestDto;
import com.project.mybible.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public void join(
            @RequestBody CreateUserRequestDto request
    ) {
        userService.join(request);
    }

    @GetMapping("/select")
    public void selectSentence(
            @RequestBody ShortLabelSearchRequestDto request
    ) {
        userService.addSentence(request);
    }

    @GetMapping("/myList")
    public List<BibleResponseDto> getMyList() {
        return userService.getMyList();
    }
}
