package com.codeup.budgets.Repositories;

import com.codeup.budgets.Models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
