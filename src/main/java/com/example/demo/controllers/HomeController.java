package com.example.demo.controllers;

import com.example.demo.models.Account;
import com.example.demo.models.Post;
import com.example.demo.services.AccountService;
import com.example.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String home(Model model){
        List<Post> posts = postService.getAll();
        List<Account> account = accountService.getAllAccountSortedByPoints();
        model.addAttribute("posts", posts);
        model.addAttribute("account",account);
        return "home";
    }

}
