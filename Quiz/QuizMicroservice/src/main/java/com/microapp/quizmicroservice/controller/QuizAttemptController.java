package com.microapp.quizmicroservice.controller;

import com.microapp.quizmicroservice.additional.SubmitQuizAttemptRequest;
import com.microapp.quizmicroservice.dto.AnswerSubmissionDto;
import com.microapp.quizmicroservice.dto.QuizAttemptDto;
import com.microapp.quizmicroservice.service.quizattempt.QuizAttemptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Quiz attempts controller", description = "Quiz attempts management endpoint")
@RestController
@RequiredArgsConstructor
@RequestMapping("/attempts")
public class QuizAttemptController {
    private final QuizAttemptService questionsService;

    @PostMapping()
    @Operation(summary = "Create attempt", description = "Makes new quiz attempt")
    public QuizAttemptDto makeQuizAttempt() {
        return questionsService.createQuizAttempt();
    }

    @PostMapping("/pass")
    @Operation(summary = "Pass attempt", description = "Submits quiz attempt")
    public QuizAttemptDto submitQuizAttempt(@RequestBody SubmitQuizAttemptRequest quizAttemptDto) {
        return questionsService.submitQuizAttempt(quizAttemptDto);
    }
}
