package com.grybos.kamil.patternsproject.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TickTacToe {

    @GetMapping(path = "/tick")
    public ResponseEntity<Map<String, String>> ping() {
        Map<String, String> map = new HashMap<>();
        map.put("tick", "tac");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
