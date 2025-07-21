package com.microapp.quizmicroservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.microapp.quizmicroservice.dto.QuestionDto;
import com.microapp.quizmicroservice.mapper.QuestionMapper;
import com.microapp.quizmicroservice.model.Question;
import com.microapp.quizmicroservice.repository.questions.QuestionsRepository;
import com.microapp.quizmicroservice.service.questions.QuestionsServiceImpl;
import com.microapp.quizmicroservice.supplier.QuestionSupplier;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class QuestionsServiceTest {
    @Mock
    private QuestionsRepository questionsRepository;
    @Mock
    private QuestionMapper questionMapper;

    @InjectMocks
    private QuestionsServiceImpl questionsService;

    @Test
    @DisplayName("Verify all questions are found")
    public void getQuestions_ShouldReturnListOfQuestions() {
        //Given (Arrange)
        List<QuestionDto> questionDtoList = QuestionSupplier.getQuestionDtoList();

        when(questionsRepository.findAll())
                .thenReturn(QuestionSupplier.getQuestionList());
        when(questionMapper.toDto(any(Question.class)))
                .thenReturn(questionDtoList.get(0));

        //When (Act)
        List<QuestionDto> actualQuestionDtoList = questionsService.getQuestions();

        //Then (Assert)
        assertEquals(questionDtoList, actualQuestionDtoList);
    }
}
