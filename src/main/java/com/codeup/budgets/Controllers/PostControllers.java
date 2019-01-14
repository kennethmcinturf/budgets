package com.codeup.budgets.Controllers;

import com.codeup.budgets.Models.Post;
import com.codeup.budgets.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostControllers {
    private final PostService postService;

    public PostControllers(PostService postService) {
        this.postService = postService;
    }

    @Controller
    class controlPost{
        @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
        public String postForm(Model model) {
            model.addAttribute("post", new Post());
            return "posts/create";
        }

        @RequestMapping(path = "/posts/create")
        @PostMapping
        public String createPost(@ModelAttribute Post post) {
            Post newPost = new Post();
            newPost.setTitle(post.getTitle());
            newPost.setBody(post.getBody());
            newPost.setHomeTeam(post.getHomeTeam());
            newPost.setAwayTeam(post.getAwayTeam());
            newPost.setAwayScore(post.getAwayScore());
            newPost.setHomeScore(post.getHomeScore());
            postService.create(newPost);
            return "redirect:http://localhost:8080/posts";
        }
    }
}
