package com.grybos.kamil.patternsproject.database;

import com.grybos.kamil.patternsproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDatabase {


    @Autowired
    public InitDatabase(UserService userService) {
        userService.create("admin", "admin", "USER");
        userService.create("tomcat", "tomcat", "USER");
    }


}