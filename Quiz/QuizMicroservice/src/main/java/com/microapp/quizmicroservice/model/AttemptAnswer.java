package com.microapp.quizmicroservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "attempt_answers")
public class AttemptAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "attempt_id", referencedColumnName = "id", nullable = false)
    private QuizAttempt attempt;
    @ManyToOne()
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
    private Question question;
    @ManyToOne()
    @JoinColumn(name = "option_id", referencedColumnName = "id", nullable = false)
    private AnswerOption option;
    //private Boolean isCorrect;
}
