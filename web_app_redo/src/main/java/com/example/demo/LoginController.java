package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping(value="/")
    public String getForm(Model model){
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping(value = "/")
    public String authenticate(@ModelAttribute Login login){
        System.out.println(login.getUser() + " " + login.getPass());
        return "home";
    }

    @GetMapping(value = "/login")
    public String getHome(){
        return "home";
    }
}