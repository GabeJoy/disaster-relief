package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class LoginController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/login")
    public Login authenticate(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Login(counter.incrementAndGet(), String.format(template, name));
    }
}