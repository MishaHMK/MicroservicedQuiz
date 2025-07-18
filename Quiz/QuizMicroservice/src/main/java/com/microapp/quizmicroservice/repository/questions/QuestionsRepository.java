package com.microapp.quizmicroservice.repository.questions;

import com.microapp.quizmicroservice.model.Question;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Question, Long> {
    @EntityGraph(attributePaths = {"answerOptions"})
    List<Question> findAll();
}
