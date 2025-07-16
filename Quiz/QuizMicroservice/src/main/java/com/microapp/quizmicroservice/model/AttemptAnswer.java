package com.microapp.quizmicroservice.model;

import jakarta.persistence.*;
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
}
