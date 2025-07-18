package com.microapp.quizmicroservice.additional;

import com.microapp.quizmicroservice.dto.AnswerSubmissionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class SubmitQuizAttemptRequest {
    private Long quizAttemptId;
    private List<AnswerSubmissionDto> answers;
}