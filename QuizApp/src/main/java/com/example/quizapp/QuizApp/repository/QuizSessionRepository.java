package com.example.quizapp.QuizApp.repository;

import com.example.quizapp.QuizApp.model.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {
}
