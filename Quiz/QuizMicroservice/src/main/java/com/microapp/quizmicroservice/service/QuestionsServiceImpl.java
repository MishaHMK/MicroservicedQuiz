package com.microapp.quizmicroservice.service;

import com.microapp.quizmicroservice.dto.QuestionDto;
import com.microapp.quizmicroservice.mapper.QuestionMapper;
import com.microapp.quizmicroservice.repository.QuestionsRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionsServiceImpl implements QuestionsService {
    private final QuestionsRepository questionsRepository;
    private final QuestionMapper questionMapper;

    @Override
    public List<QuestionDto> getQuestions() {
        return questionsRepository.findAll()
                .stream()
                .map(questionMapper::toDto)
                .toList();
    }
}
