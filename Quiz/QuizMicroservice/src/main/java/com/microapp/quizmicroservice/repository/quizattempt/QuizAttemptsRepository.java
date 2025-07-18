package com.microapp.quizmicroservice.repository.quizattempt;

import com.microapp.quizmicroservice.model.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizAttemptsRepository extends JpaRepository<QuizAttempt, Long> {
}
