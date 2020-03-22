package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(method=RequestMethod.GET)
    public String getForm(){
        return "login";
    }

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String authenticate(){
        return "home";
    }
}