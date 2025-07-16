package com.microapp.quizmicroservice.service;

import com.microapp.quizmicroservice.model.Question;
import com.microapp.quizmicroservice.repository.QuestionsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionsServiceImpl implements QuestionsService {
    private final QuestionsRepository questionsRepository;

    @Override
    public List<Question> getQuestions() {
        return questionsRepository.findAll();
    }
}
