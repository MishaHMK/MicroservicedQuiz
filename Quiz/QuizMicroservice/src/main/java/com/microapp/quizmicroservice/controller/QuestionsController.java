package com.microapp.quizmicroservice.controller;

import com.microapp.quizmicroservice.model.Question;
import com.microapp.quizmicroservice.service.QuestionsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Questions controller", description = "Questions management endpoint")
@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionsController {
    private final QuestionsService questionsService;

    @GetMapping("/all")
    @Operation(summary = "Get all", description = "Receive all questions in system")
    public List<Question> register() {
        return questionsService.getQuestions();
    }
}
