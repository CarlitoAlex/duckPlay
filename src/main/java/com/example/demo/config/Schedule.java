package com.example.demo.config;

import com.example.demo.models.Account;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
public class Schedule {
    @Autowired
    private AccountService accountService;

    @Scheduled(cron = "0 */2 * ? * *")
    public void scheduleFixedDelayTask() {

    }

    private List<Account> getAllUserToClearQuiz(){
        return accountService.getAllAccount();
    }


}
