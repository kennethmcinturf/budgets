package com.codeup.budgets.Controllers;

import com.codeup.budgets.Models.Post;
import com.codeup.budgets.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            newPost.setDate(post.getDate());
            newPost.setHomeTeam(post.getHomeTeam());
            newPost.setAwayTeam(post.getAwayTeam());
            newPost.setAwayScore(post.getAwayScore());
            newPost.setHomeScore(post.getHomeScore());
            postService.create(newPost);
            return "redirect:http://localhost:8080/posts";
        }

        @RequestMapping(path = "/posts", method = RequestMethod.GET)
        public String post(Model model) {
            List<Post> posts = postService.all();
            model.addAttribute("posts", posts);
            return "posts/index";
        }

        @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
        public String indivPost(@PathVariable int id, Model model) {
            Post post = postService.one(id);
            model.addAttribute("post", post);
            return "posts/show";
        }

        @RequestMapping(path = "/posts/{id}/delete", method = RequestMethod.GET)
        public String goToDelete(@PathVariable int id, Model model) {
            Post post = postService.one(id);
            model.addAttribute("post", post);
            return "posts/confirmDelete";
        }

        @RequestMapping(path = "/posts/{id}/delete", method = RequestMethod.POST)
        public String delete(@PathVariable int id, Model model) {
            postService.delete(id);
            return "redirect:http://localhost:8080/posts";
        }
    }
}
