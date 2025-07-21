package com.microapp.quizmicroservice.supplier;

import com.microapp.quizmicroservice.dto.AnswerOptionDto;
import com.microapp.quizmicroservice.dto.QuestionDto;
import com.microapp.quizmicroservice.model.AnswerOption;
import com.microapp.quizmicroservice.model.Question;
import java.util.List;
import java.util.Set;

public class QuestionSupplier {
    public static QuestionDto getQuestionDto() {
        return new QuestionDto()
                .setId(1L)
                .setText("SomeQuestion")
                .setAnswerOptionsDto(Set.of(QuestionSupplier.getAnswerOptionDto()));
    }

    public static List<QuestionDto> getQuestionDtoList() {
        return List.of(getQuestionDto());
    }

    public static AnswerOptionDto getAnswerOptionDto() {
        return new AnswerOptionDto()
                .setId(1L)
                .setText("SomeAnswer")
                .setIsCorrect(true);
    }

    public static Question getQuestion() {
        return new Question()
                .setId(1L)
                .setText("SomeQuestion")
                .setAnswerOptions(Set.of(QuestionSupplier.getAnswerOption()));
    }

    public static AnswerOption getAnswerOption() {
        return new AnswerOption()
                .setId(1L)
                .setText("SomeAnswer")
                .setIsCorrect(true);
    }

    public static List<Question> getQuestionList() {
        return List.of(getQuestion());
    }
}
