package com.example.doranawstest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        String message = "Hello Word!";
        return ResponseEntity.ok(message);
    }
}
