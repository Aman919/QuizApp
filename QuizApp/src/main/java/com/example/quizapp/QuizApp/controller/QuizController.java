package com.example.quizapp.QuizApp.controller;

import com.example.quizapp.QuizApp.model.*;
import com.example.quizapp.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public ResponseEntity<QuizSession> startQuiz(){
        return ResponseEntity.ok(quizService.startNewQuiz());
    }

    @GetMapping("/question")
    public ResponseEntity<Question> getRandomQuestion(){
        return ResponseEntity.ok(quizService.getRandomQuestion());
    }

    @PostMapping("/submit")
    public ResponseEntity<UserAnswer> submitAnswer(
            @RequestParam Long sessionId,
            @RequestParam Long questionId,
            @RequestParam String selectedOption) {
        return ResponseEntity.ok(quizService.submitAnswer(sessionId, questionId, selectedOption));
    }


    @GetMapping("/results")
    public ResponseEntity<List<UserAnswer>> getResults(@RequestParam Long sessionId){
        return ResponseEntity.ok(quizService.getQuizResult(sessionId));
    }
}
