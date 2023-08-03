package com.example.demo.config;

import com.example.demo.models.Account;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableScheduling
public class Schedule {
    @Autowired
    private AccountService accountService;

    @Scheduled(cron = "0 */2 * ? * *")
    public void scheduleFixedDelayTask() {
        System.out.println("Разница между endtime and star time" + check5MinutesDiffToClear());
        System.out.println("Разница между endtime and current time" + check5MinutesDiffToClearWholeTime());
        System.out.println(check5MinutesDiffToClearWholeTime());
        Optional<Account> accountOptional = accountService.findByEmail(getAllUserToClearQuiz().get(0).getEmail());
        if (accountOptional.isPresent() && check5MinutesDiffToClearWholeTime() > 3 || accountOptional.isPresent() && check5MinutesDiffToClear() > 3 ){
            Account account = accountOptional.get();
            account.setQuizSession(null);
            account.setTryCountQuiz(0);
            accountService.save(account);
            System.out.println("Clear account session quiz");
        }else {
            System.out.println("Nothing to clear");
        }
    }

    private List<Account> getAllUserToClearQuiz(){
        return accountService.getAllAccount();
    }


    public long check5MinutesDiffToClear(){
        List<Account> list = getAllUserToClearQuiz();
        try{
            LocalDateTime start = list.get(0).getQuizSession().getStartTime();
            LocalDateTime endTime = list.get(0).getQuizSession().getEndTime();
            return Duration.between(start, endTime).toMinutes();
        } catch (Exception ignored){
        }
        return 0;
    }

    public long check5MinutesDiffToClearWholeTime(){
        List<Account> list = getAllUserToClearQuiz();
        try{
            LocalDateTime start = LocalDateTime.now();
            LocalDateTime endTime = list.get(0).getQuizSession().getEndTime();
            return Duration.between(endTime, start).toMinutes();
        } catch (Exception ignored){
        }
        return 0;
    }

}
