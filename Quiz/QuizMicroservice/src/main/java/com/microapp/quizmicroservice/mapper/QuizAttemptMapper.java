package com.microapp.quizmicroservice.mapper;

import com.microapp.quizmicroservice.config.MapperConfig;
import com.microapp.quizmicroservice.dto.QuizAttemptDto;
import com.microapp.quizmicroservice.model.QuizAttempt;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface QuizAttemptMapper {
    QuizAttemptDto toDto(QuizAttempt entity);
}
