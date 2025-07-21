package com.microapp.quizmicroservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class AnswerSubmissionDto {
    private Long questionId;
    private Long selectedOptionId;
}
