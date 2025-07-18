package com.microapp.quizmicroservice.service.quizattempt;

import com.microapp.quizmicroservice.additional.SubmitQuizAttemptRequest;
import com.microapp.quizmicroservice.dto.AnswerSubmissionDto;
import com.microapp.quizmicroservice.dto.QuizAttemptDto;
import com.microapp.quizmicroservice.mapper.QuizAttemptMapper;
import com.microapp.quizmicroservice.model.AnswerOption;
import com.microapp.quizmicroservice.model.Question;
import com.microapp.quizmicroservice.model.QuizAttempt;
import com.microapp.quizmicroservice.repository.questions.QuestionsRepository;
import com.microapp.quizmicroservice.repository.quizattempt.QuizAttemptsRepository;
import com.microapp.quizmicroservice.security.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
@RequiredArgsConstructor
public class QuizAttemptServiceImpl implements QuizAttemptService {
    private final QuizAttemptsRepository quizAttemptsRepository;
    private final QuestionsRepository questionsRepository;
    private final QuizAttemptMapper quizAttemptMapper;

    @Override
    public QuizAttemptDto createQuizAttempt() {
        Long currentUserId = SecurityUtil.getCurrentUserId();
        QuizAttempt quizAttempt = new QuizAttempt().setUserId(currentUserId);
        quizAttemptsRepository.save(quizAttempt);
        return quizAttemptMapper.toDto(quizAttempt);
    }

    @Override
    public QuizAttemptDto submitQuizAttempt(SubmitQuizAttemptRequest quizAttemptDto) {
        Long currentUserId = SecurityUtil.getCurrentUserId();
        List<Question> allQuestions = questionsRepository.findAll().stream().toList();
        List<AnswerSubmissionDto> answers = quizAttemptDto.getAnswers();
        AtomicLong rightAnswers = new AtomicLong(0L);

        for (AnswerSubmissionDto answer : answers) {
            Question question = allQuestions.stream()
                    .filter(q -> q.getId().equals(answer.getQuestionId()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            AnswerOption selectedOption = question.getAnswerOptions().stream()
                    .filter(ao -> ao.getId().equals(answer.getSelectedOptionId()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Answer not found"));

            if (selectedOption.getIsCorrect()) {
                rightAnswers.incrementAndGet();
            }
        };

        QuizAttempt quizAttempt = quizAttemptsRepository.findById(quizAttemptDto.getQuizAttemptId()).get();

        Long score = rightAnswers.get() * 10 / allQuestions.size();

        quizAttempt.setScore(score);
        quizAttempt.setAttemptDate(LocalDateTime.now());
        quizAttemptsRepository.save(quizAttempt);
        return quizAttemptMapper.toDto(quizAttempt);
    }
}
