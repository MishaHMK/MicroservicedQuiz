package com.microapp.quizmicroservice.controller;

import com.microapp.quizmicroservice.clients.AuthClient;
import com.microapp.quizmicroservice.dto.QuestionDto;
import com.microapp.quizmicroservice.model.QuizAttempt;
import com.microapp.quizmicroservice.security.SecurityUtil;
import com.microapp.quizmicroservice.service.questions.QuestionsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Questions controller", description = "Questions management endpoint")
@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionsController {
    private final QuestionsService questionsService;
    private final AuthClient authClient;

    @GetMapping("/all")
    @Operation(summary = "Get all", description = "Receive all questions in system")
    public List<QuestionDto> getAllQuestions() {
        String auth = authClient.auth();
        return questionsService.getQuestions();
    }
}
