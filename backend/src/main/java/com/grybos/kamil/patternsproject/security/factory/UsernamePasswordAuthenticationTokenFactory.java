package com.grybos.kamil.patternsproject.security.factory;

import com.grybos.kamil.patternsproject.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UsernamePasswordAuthenticationTokenFactory {

    public UsernamePasswordAuthenticationToken create(User u) {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(u.getRole());
        return new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword(), Arrays.asList(simpleGrantedAuthority));
    }

}