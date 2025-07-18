package com.microapp.quizmicroservice.mapper;

import com.microapp.quizmicroservice.config.MapperConfig;
import com.microapp.quizmicroservice.dto.QuestionDto;
import com.microapp.quizmicroservice.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface QuestionMapper {
    @Mapping(source = "answerOptions", target = "answerOptionsDto")
    QuestionDto toDto(Question entity);
}
