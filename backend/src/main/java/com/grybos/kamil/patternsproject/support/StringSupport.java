package com.grybos.kamil.patternsproject.support;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StringSupport {

    public String generate() {
        return UUID.randomUUID().toString();
    }

}
