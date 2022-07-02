package com.project.mybible.user.facade;

import com.project.mybible.user.domain.User;
import com.project.mybible.user.domain.repository.UserRepository;
import com.project.mybible.user.exception.MyListEmptyException;
import com.project.mybible.user.exception.UserAlreadyExistsException;
import com.project.mybible.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public void validateEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
    }

    public User getUser(Long id) {
        return userRepository.findById(1L)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void validateMyList(User user) {
        if (user.getMyList().size() == 0)
            throw MyListEmptyException.EXCEPTION;
    }
}
