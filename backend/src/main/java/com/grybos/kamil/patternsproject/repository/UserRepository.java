package com.grybos.kamil.patternsproject.repository;

import com.grybos.kamil.patternsproject.model.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

    void deleteByUsername(String username);

    void delete(User user);

}