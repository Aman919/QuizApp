package com.example.quizapp.QuizApp.service;

import com.example.quizapp.QuizApp.model.*;
import com.example.quizapp.QuizApp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UserAnswerRepository userAnswerRepository;
    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @Override
    public QuizSession startNewQuiz() {
        QuizSession session = new QuizSession();
        session.setUserId("default-user");
        session.setTotalQuestionAnswered(0);
        session.setCorrectAnswers(0);
        return quizSessionRepository.save(session);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();

        if(questions.isEmpty()){
            throw new RuntimeException("No Questions available");
        }

        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }

    @Override
    public UserAnswer submitAnswer(Long sessionId, Long questionId, String selectedOption) {
        QuizSession session = quizSessionRepository.findById(sessionId)
                .orElseThrow(()-> new RuntimeException(("session not found")));

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        boolean isCorrect= question.getCorrectAnswer().equalsIgnoreCase(selectedOption);

        UserAnswer userAnswer = new UserAnswer(null, sessionId, questionId, selectedOption, isCorrect);
        userAnswerRepository.save(userAnswer);

        //update session stats
        session.setTotalQuestionAnswered(session.getTotalQuestionAnswered()+1);
        if(isCorrect){
            session.setCorrectAnswers(session.getCorrectAnswers()+1);
        }
        quizSessionRepository.save(session);

        return userAnswer;
    }

    @Override
    public List<UserAnswer> getQuizResult(Long sessionId) {
        return userAnswerRepository.findBySessionId(sessionId);
    }
}
