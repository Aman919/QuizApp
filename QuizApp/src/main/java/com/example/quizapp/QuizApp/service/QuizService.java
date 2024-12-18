package com.example.quizapp.QuizApp.service;

import com.example.quizapp.QuizApp.model.Question;
import com.example.quizapp.QuizApp.model.QuizSession;
import com.example.quizapp.QuizApp.model.UserAnswer;

import java.util.List;

public interface QuizService {
    QuizSession startNewQuiz();
    Question getRandomQuestion();
    UserAnswer submitAnswer(Long sessionId, Long questionId, String selectedOption);
    List<UserAnswer> getQuizResult(Long sessionId);
}
