package com.codeup.budgets.Services;

import com.codeup.budgets.Models.Post;
import com.codeup.budgets.Repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Post> all(){
        return  (List<Post>) postsDao.findAll();
    }

    public Post one(int id){
        return postsDao.findOne(id);
    }

    public void delete(int id){
        Post post = postsDao.findOne(id);
        postsDao.delete(post);
    }
}

