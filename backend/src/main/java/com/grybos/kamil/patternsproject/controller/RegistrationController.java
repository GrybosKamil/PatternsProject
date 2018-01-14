package com.grybos.kamil.patternsproject.controller;

import com.grybos.kamil.patternsproject.model.User;
import com.grybos.kamil.patternsproject.service.UserService;
import org.apache.catalina.connector.Response;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/member")
    Integer registrationMember(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return Response.SC_BAD_REQUEST;
        }
        String decodedPassword = Utf8.decode(Base64.decodeBase64(password.getBytes()));
        userService.createMember(username, decodedPassword, "USER");
        return Response.SC_OK;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/organizer")
    Integer registrationOrganizer(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return Response.SC_BAD_REQUEST;
        }
        String decodedPassword = Utf8.decode(Base64.decodeBase64(password.getBytes()));
        userService.createOrganizer(username, decodedPassword, "USER");
        return Response.SC_OK;
    }

}
