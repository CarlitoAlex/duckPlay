package com.example.demo.controllers;

import com.example.demo.models.Account;
import com.example.demo.models.Quiz;
import com.example.demo.models.QuizSession;
import com.example.demo.services.AccountService;
import com.example.demo.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private AccountService accountService;


    @GetMapping("/getQuiz")
    public String getAllQuiz(Model model) {
        Account account = getCurrentSession();
        int tryCurrentQuiz = account.getTryCountQuiz();
        if (tryCurrentQuiz > 20){
            return "quizPause";
        }

        List<Quiz> quizList = quizService.getAllQuiz();
        Random random = new Random();
        Quiz quiz = quizList.get(random.nextInt(quizList.size()));
        model.addAttribute("quiz", quiz);

        return "quiz";
    }

    public Account getCurrentSession(){
        Account account = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Optional<Account> accountOptional = accountService.findByEmail(currentPrincipalName);

        if (accountOptional.isPresent()){
            account = accountOptional.get();
        }
        return account;
    }

    @PostMapping("/checkAnswerForQuiz")
    public String checkAnswer(@ModelAttribute Quiz quiz) {
        Account account = getCurrentSession();
        String answer = quiz.getAnswer();
        QuizSession quizSession = account.getQuizSession();

        if (account.getQuizSession() == null){
            quizSession = new QuizSession();
            quizSession.setStartTime(LocalDateTime.now());
            account.setQuizSession(quizSession);
            accountService.updateAnswers(account);
        }

        String answerChoice = quiz.getAnswerChoice().replaceAll(",", "");
        int currentCount = account.getCorrectAnswers();
        int tryCurrentQuiz = account.getTryCountQuiz();

        if (tryCurrentQuiz >= 20){
            quizSession.setEndTime(LocalDateTime.now());
            account.setQuizSession(quizSession);
            accountService.updateAnswers(account);
            return "quizPause";
        }

        if (answerChoice.equals(answer)) {
            System.out.println("CORRECT");
            currentCount++;
            tryCurrentQuiz++;
            account.setCorrectAnswers(currentCount);
            account.setTryCountQuiz(tryCurrentQuiz);
            accountService.updateAnswers(account);
        } else {
            System.out.println("WRONG");
            tryCurrentQuiz++;
            account.setTryCountQuiz(tryCurrentQuiz);
            System.out.println(quiz.getAnswer() + " but choices" + quiz.getAnswerChoice());
            accountService.updateAnswers(account);
        }

        return "redirect:/getQuiz";
    }

}
