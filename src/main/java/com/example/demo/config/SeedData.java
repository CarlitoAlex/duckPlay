package com.example.demo.config;

import com.example.demo.models.Account;
import com.example.demo.models.Authority;
import com.example.demo.models.Post;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.services.AccountService;
import com.example.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityRepository authorityRepository;


    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0){

            Authority user1 = new Authority();
            Authority user2 = new Authority();

            user1.setName("ROLE_ADMIN");
            user2.setName("ROLE_USER");

            authorityRepository.save(user1);
            authorityRepository.save(user2);

            Account account1 = new Account();
            Account account2 = new Account();

            account1.setEmail("bla@test.com");
            account2.setEmail("bla@test1.com");

            account1.setPassword("123");
            account2.setPassword("123");

            account1.setUsername("acc1");
            account2.setUsername("acc2");

            Set<Authority> authorities1 = new HashSet<>();
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities1::add);
            account1.setAuthorities(authorities1);

            Set<Authority> authorities2 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities2::add);
            account2.setAuthorities(authorities2);

            accountService.save(account1);
            accountService.save(account2);

            Post post1 = new Post();
            post1.setTitle("Some test");
            post1.setBody("Some test Some test Some test Some test Some test Some test Some test Some test Some test " +
                    "\n Some test Some test Some test Some test Some test");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("Some test 2");
            post2.setBody("Some test Some test Some test Some test Some test Some test Some test Some test Some test " +
                    "\n Some test Some test Some test Some test Some test");
            post2.setAccount(account2);

            postService.save(post1);
            postService.save(post2);
        }
    }
}
