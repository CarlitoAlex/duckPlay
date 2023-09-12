package com.example.demo.services;

import com.example.demo.models.Quiz;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Optional<Quiz> getQuizById(Long id){
            return quizRepository.findById(id);
    }

    public List<Quiz> getAllQuiz(){
        return quizRepository.findAll();
    }

    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }
}
