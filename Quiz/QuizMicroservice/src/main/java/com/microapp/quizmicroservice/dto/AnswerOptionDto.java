package com.microapp.quizmicroservice.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AnswerOptionDto {
    private Long id;
    private String text;
    private Boolean isCorrect;
}
