package com.project.mybible.user.domain.repository;

import com.project.mybible.user.domain.MySentence;
import com.project.mybible.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MySentenceRepository extends JpaRepository<MySentence, Long> {
}
