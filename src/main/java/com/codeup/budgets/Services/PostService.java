package com.codeup.budgets.Services;

import com.codeup.budgets.Models.Post;
import com.codeup.budgets.Repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postsDao;

    public PostService(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    public Post create(Post post) {
        postsDao.save(post);
        return post;
    }
}
