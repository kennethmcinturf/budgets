package com.codeup.budgets.Repositories;

import com.codeup.budgets.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
