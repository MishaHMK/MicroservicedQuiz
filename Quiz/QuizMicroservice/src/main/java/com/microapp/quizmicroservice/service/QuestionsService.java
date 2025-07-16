package com.microapp.quizmicroservice.service;

import com.microapp.quizmicroservice.model.Question;
import java.util.List;

public interface QuestionsService {
    List<Question> getQuestions();
}
