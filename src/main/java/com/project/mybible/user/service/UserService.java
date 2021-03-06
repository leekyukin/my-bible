package com.project.mybible.user.service;

import com.project.mybible.bible.domain.Bible;
import com.project.mybible.bible.facade.BibleFacade;
import com.project.mybible.bible.presentation.dto.request.ShortLabelSearchRequestDto;
import com.project.mybible.bible.presentation.dto.response.BibleResponseDto;
import com.project.mybible.user.domain.MySentence;
import com.project.mybible.user.domain.User;
import com.project.mybible.user.domain.repository.MySentenceRepository;
import com.project.mybible.user.domain.repository.UserRepository;
import com.project.mybible.user.facade.UserFacade;
import com.project.mybible.user.presentation.dto.request.CreateUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final BibleFacade bibleFacade;
    private final MySentenceRepository mySentenceRepository;


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

        User user = userFacade.getUser(3L);

        mySentenceRepository.save(MySentence.setMyList(user, bible));
    }

    @Transactional(readOnly = true)
    public List<BibleResponseDto> getMyList() {
        User user = userFacade.getUser(3L);

        return user.getMyList().stream()
                .map(MySentence::getBible)
                .map(BibleResponseDto::of)
                .collect(toList());
    }
}
