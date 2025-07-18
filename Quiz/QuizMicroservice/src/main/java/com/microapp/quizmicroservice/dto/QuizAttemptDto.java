package com.microapp.quizmicroservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class QuizAttemptDto {
    private Long id;
    private Long userId;
    private LocalDateTime attemptDate;
    private Long score;
}
