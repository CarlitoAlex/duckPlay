package com.example.demo.controllers;

import com.example.demo.models.Account;
import com.example.demo.models.Post;
import com.example.demo.services.AccountService;
import com.example.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model){
        Optional<Post> optionalPost = postService.getById(id);
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post";
        }else {
            return "404";
        }
    }

    @GetMapping("/posts/new")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String createNewPost(Model model, Principal principal) {

        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }

        Optional<Account> optionalAccount = accountService.findByEmail(authUsername);
        if (optionalAccount.isPresent()) {
            Post post = new Post();
            post.setAccount(optionalAccount.get());
            model.addAttribute("post", post);
            return "post_new";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/posts/new")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String createNewPost(@ModelAttribute Post post, Principal principal) {
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }

        try {
            if (post.getAccount().getEmail().compareToIgnoreCase(authUsername) < 0) {
                // TODO: some kind of error?
                // our account email on the Post not equal to current logged in account!
            }
        }catch (Exception ignored){

        }

        postService.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts/{id}/edit/")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getPostForEdit(@PathVariable Long id, Model model){
        Optional<Post> optionalPost = postService.getById(id);

        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post_edit";
        }else {
            return "404";
        }
    }

    @PostMapping("/posts/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String updatePost(@PathVariable Long id, Post post){
        Optional<Post> optionalPost = postService.getById(id);

        if (optionalPost.isPresent()){
            Post existingPost = optionalPost.get();
            existingPost.setTitle(post.getTitle());
            existingPost.setBody(post.getBody());
            postService.save(existingPost);
        }
        return "redirect:/posts/" + post.getId();
    }


    @GetMapping("/posts/{id}/delete/")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getPostForEdit(@PathVariable Long id){
        Optional<Post> optionalPost = postService.getById(id);

        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            postService.deletePost(post);
            return "redirect:/";
        }else {
            return "404";
        }
    }
}
