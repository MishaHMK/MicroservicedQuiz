package com.microapp.quizmicroservice.supplier;

import com.microapp.quizmicroservice.additional.SubmitQuizAttemptRequest;
import com.microapp.quizmicroservice.dto.AnswerSubmissionDto;
import com.microapp.quizmicroservice.dto.QuizAttemptDto;
import com.microapp.quizmicroservice.model.AnswerOption;
import com.microapp.quizmicroservice.model.AttemptAnswer;
import com.microapp.quizmicroservice.model.Question;
import com.microapp.quizmicroservice.model.QuizAttempt;
import java.time.LocalDateTime;
import java.util.List;

public class QuizAttemptSupplier {
    public static QuizAttemptDto getQuizAttemptDto() {
        return new QuizAttemptDto()
                .setId(1L)
                .setUserId(1L)
                .setAttemptDate(LocalDateTime.now())
                .setScore(10L);
    }

    public static QuizAttempt getQuizAttempt() {
        return new QuizAttempt()
                .setId(1L)
                .setUserId(1L)
                .setAttemptDate(LocalDateTime.now())
                .setScore(10L)
                .setAttemptAnswers(
                        List.of(new AttemptAnswer()
                                .setId(1L)
                                .setAttempt(new QuizAttempt())
                                .setQuestion(new Question())
                                .setOption(new AnswerOption())
                        ));
    }

    public static SubmitQuizAttemptRequest getQuizSubmissionForm() {
        return new SubmitQuizAttemptRequest()
                .setQuizAttemptId(getQuizAttempt().getId())
                .setAnswers(List.of(new AnswerSubmissionDto()
                        .setQuestionId(getQuizAttempt().getId())
                        .setSelectedOptionId(1L)));
    }
}
