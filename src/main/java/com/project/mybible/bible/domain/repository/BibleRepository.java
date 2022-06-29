package com.project.mybible.bible.domain.repository;

import com.project.mybible.bible.domain.Bible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BibleRepository extends JpaRepository<Bible, Long> {

    Optional<List<Bible>> findAllByShortLabelAndChapter(String shortLabel, int chapter);

   Optional<Bible> findByShortLabelAndChapterAndParagraph(String shortLabel, int chapter, int paragraph);
}
