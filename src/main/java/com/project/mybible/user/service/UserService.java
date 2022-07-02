package com.project.mybible.user.service;

import com.project.mybible.user.domain.repository.UserRepository;
import com.project.mybible.user.facade.UserFacade;
import com.project.mybible.user.presentation.dto.request.CreateUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;


    @Transactional
    public void join(CreateUserRequestDto request) {
        userFacade.validateEmail(request.getEmail());

        userRepository.save(request.toEntity());
    }

    @Transactional
    public void selectSentence(ShortLabelSearchRequestDto request) {
        Bible bible = bibleFacade.getSentence(
                request.getShortLabel(),
                request.getChapter(),
                request.getParagraph()
        );

        User user = userFacade.getUser(1L);

        bible.setUser(user);
    }

}
