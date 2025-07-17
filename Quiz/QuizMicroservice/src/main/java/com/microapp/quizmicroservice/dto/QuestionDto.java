package com.microapp.quizmicroservice.dto;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class QuestionDto {
    private Long id;
    private String text;
    private Set<AnswerOptionDto> answerOptionsDto = new HashSet<>();
}
