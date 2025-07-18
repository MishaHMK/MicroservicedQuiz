package com.microapp.quizmicroservice.dto;

import lombok.Getter;

@Getter
public class AnswerSubmissionDto {
    private Long questionId;
    private Long selectedOptionId;
}