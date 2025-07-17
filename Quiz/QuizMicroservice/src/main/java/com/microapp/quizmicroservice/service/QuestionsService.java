package com.microapp.quizmicroservice.service;

import com.microapp.quizmicroservice.dto.QuestionDto;
import java.util.List;

public interface QuestionsService {
    List<QuestionDto> getQuestions();
}
