package com.example.demo.controllers;

import com.example.demo.models.Account;
import com.example.demo.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        Account account = new Account();
        model.addAttribute("account",account);
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute @Valid Account account, BindingResult bindingResult){
        Account account1;

        if (bindingResult.hasErrors()){
            return "register";
        }

        if (accountService.findByEmail(account.getEmail()).isPresent()){
            account1 = accountService.findByEmail(account.getEmail()).get();
            System.out.println("We are find account in system " + account1.getEmail());
            return "register";
        }else {
            System.out.println("Creating new account");
            accountService.save(account);
            return "redirect:/";
        }
    }
}
