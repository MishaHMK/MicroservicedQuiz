package com.microapp.quizmicroservice.additional;

import com.microapp.quizmicroservice.dto.AnswerSubmissionDto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class SubmitQuizAttemptRequest {
    private Long quizAttemptId;
    private List<AnswerSubmissionDto> answers;
}
