package com.microapp.quizmicroservice.service.quizattempt;

import com.microapp.quizmicroservice.additional.SubmitQuizAttemptRequest;
import com.microapp.quizmicroservice.dto.QuizAttemptDto;

public interface QuizAttemptService {
    QuizAttemptDto createQuizAttempt();
    QuizAttemptDto submitQuizAttempt(SubmitQuizAttemptRequest quizAttemptDto);
}
