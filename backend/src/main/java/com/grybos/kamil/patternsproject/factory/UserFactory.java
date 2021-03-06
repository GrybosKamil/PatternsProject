package com.grybos.kamil.patternsproject.factory;

import com.grybos.kamil.patternsproject.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    public User create(String username, String password, String salt, String role) {
        return new User(username, password, salt, role);
    }

}
