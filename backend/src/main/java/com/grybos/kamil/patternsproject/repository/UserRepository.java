package com.grybos.kamil.patternsproject.repository;

import com.grybos.kamil.patternsproject.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}