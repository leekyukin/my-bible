package com.project.mybible.user.service;

import com.project.mybible.bible.domain.Bible;
import com.project.mybible.bible.facade.BibleFacade;
import com.project.mybible.bible.presentation.dto.request.ShortLabelSearchRequestDto;
import com.project.mybible.bible.presentation.dto.response.BibleResponseDto;
import com.project.mybible.user.domain.User;
import com.project.mybible.user.domain.repository.UserRepository;
import com.project.mybible.user.facade.UserFacade;
import com.project.mybible.user.presentation.dto.request.CreateUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final BibleFacade bibleFacade;


    @Transactional
    public void join(CreateUserRequestDto request) {
        userFacade.validateEmail(request.getEmail());

        userRepository.save(request.toEntity());
    }

    @Transactional
    public void addSentence(ShortLabelSearchRequestDto request) {
        Bible bible = bibleFacade.getSentence(
                request.getShortLabel(),
                request.getChapter(),
                request.getParagraph()
        );

        User user = userFacade.getUser(1L);

        bible.setUser(user);
    }

    @Transactional(readOnly = true)
    public List<BibleResponseDto> getMyList() {
        User user = userFacade.getUser(1L);
        userFacade.validateMyList(user);

        return user.getMyList().stream()
                .map(BibleResponseDto::of)
                .collect(toList());
    }
}
