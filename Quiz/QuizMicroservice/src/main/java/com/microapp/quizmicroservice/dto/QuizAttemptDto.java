package com.microapp.quizmicroservice.dto;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class QuizAttemptDto {
    private Long id;
    private Long userId;
    private LocalDateTime attemptDate;
    private Long score;
}
