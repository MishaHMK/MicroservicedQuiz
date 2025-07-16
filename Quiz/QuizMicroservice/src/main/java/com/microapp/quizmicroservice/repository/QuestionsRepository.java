package com.microapp.quizmicroservice.repository;

import com.microapp.quizmicroservice.model.Question;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Question, Long> {
    @EntityGraph(attributePaths = {"answerOptions"})
    List<Question> findAll();
}
