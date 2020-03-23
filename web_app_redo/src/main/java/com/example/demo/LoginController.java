package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(method=RequestMethod.GET)
    public String getForm(Model model){
        Login login = new Login();
        model.addAttribute("user", login);
        return "login";
    }

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String authenticate(){
        return "home";
    }
}