package com.codeup.budgets.Repositories;

import com.codeup.budgets.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
