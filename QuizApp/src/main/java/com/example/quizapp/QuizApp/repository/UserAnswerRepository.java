package com.example.quizapp.QuizApp.repository;

import com.example.quizapp.QuizApp.model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
    List<UserAnswer> findBySessionId(Long sessionId);
}
