package com.example.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
//@PreAuthorize("hasRole('Administrator')")
public class AdminController {

    @GetMapping(value="")
    public String getAdmin(){
        return "admin";
    }

    @GetMapping("/view-requests")
    public String viewRequests(){
        return "view-requests";
    }

    @GetMapping("/match-requests")
    public String matchRequests(){
        return "match-requests";
    }
}
