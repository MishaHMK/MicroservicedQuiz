package com.microapp.quizmicroservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.microapp.quizmicroservice.additional.SubmitQuizAttemptRequest;
import com.microapp.quizmicroservice.dto.QuizAttemptDto;
import com.microapp.quizmicroservice.mapper.QuizAttemptMapper;
import com.microapp.quizmicroservice.model.Question;
import com.microapp.quizmicroservice.model.QuizAttempt;
import com.microapp.quizmicroservice.repository.questions.QuestionsRepository;
import com.microapp.quizmicroservice.repository.quizattempt.QuizAttemptsRepository;
import com.microapp.quizmicroservice.security.UserPrincipal;
import com.microapp.quizmicroservice.service.quizattempt.QuizAttemptServiceImpl;
import com.microapp.quizmicroservice.supplier.QuestionSupplier;
import com.microapp.quizmicroservice.supplier.QuizAttemptSupplier;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@ExtendWith(MockitoExtension.class)
public class QuizAttemptServiceTest {
    @Mock
    private QuizAttemptsRepository quizAttemptsRepository;
    @Mock
    private QuestionsRepository questionsRepository;
    @Mock
    private QuizAttemptMapper quizAttemptMapper;

    @InjectMocks
    private QuizAttemptServiceImpl quizAttemptService;

    @AfterEach
    void clearSecurityContext() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void createQuizAttempt_ShouldThrowException_WhenPrincipalIsInvalid() {
        Authentication authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn("invalidPrincipal");

        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        SecurityContextHolder.setContext(securityContext);

        assertThrows(IllegalStateException.class, () -> quizAttemptService.createQuizAttempt());
    }

    @Test
    @DisplayName("Verify quiz attempt created")
    public void createQuizAttempt_ShouldReturnQuizAttemptDto() {
        //Given (Arrange)
        QuizAttemptDto quizAttemptDto = QuizAttemptSupplier.getQuizAttemptDto();
        QuizAttempt quizAttempt = QuizAttemptSupplier.getQuizAttempt();

        when(quizAttemptMapper.toDto(any(QuizAttempt.class)))
                .thenReturn(quizAttemptDto);
        when(quizAttemptsRepository.save(any(QuizAttempt.class)))
                .thenReturn(quizAttempt);

        UserPrincipal userPrincipal = new UserPrincipal(1L, "testuser@gmail.com");

        Authentication authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(userPrincipal);

        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        SecurityContextHolder.setContext(securityContext);

        //When (Act)
        QuizAttemptDto actualQuizAttemptDto = quizAttemptService.createQuizAttempt();

        //Then (Assert)
        assertEquals(quizAttemptDto, actualQuizAttemptDto);
    }

    @Test
    @DisplayName("Verify all questions are found")
    public void submitQuizAttempt_ShouldReturnQuizAttemptDto() {
        //Given (Arrange)
        QuizAttempt quizAttempt = QuizAttemptSupplier.getQuizAttempt();
        quizAttempt.setAttemptAnswers(new ArrayList<>());
        List<Question> questionList = QuestionSupplier.getQuestionList();
        SubmitQuizAttemptRequest submitRequest = QuizAttemptSupplier.getQuizSubmissionForm();

        when(questionsRepository.findAll())
                .thenReturn(questionList);
        when(quizAttemptsRepository.findById(1L))
                .thenReturn(Optional.ofNullable(quizAttempt));
        when(quizAttemptsRepository.save(any(QuizAttempt.class)))
                .thenReturn(quizAttempt);

        QuizAttemptDto quizAttemptDto = QuizAttemptSupplier.getQuizAttemptDto();
        when(quizAttemptMapper.toDto(any(QuizAttempt.class)))
                .thenReturn(quizAttemptDto);

        //When (Act)
        QuizAttemptDto actualQuizAttemptDto = quizAttemptService.submitQuizAttempt(submitRequest);

        //Then (Assert)
        assertEquals(quizAttemptDto, actualQuizAttemptDto);
    }
}
