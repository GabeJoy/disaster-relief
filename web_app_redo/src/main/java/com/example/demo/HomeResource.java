package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class HomeResource {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping(value = "/newuser")
    public String getNewUser(Model model){
        model.addAttribute("user", new User());
        return "newuser";
    }

    @PostMapping(value = "/newuser")
    public String addNewUser(@ModelAttribute User user, @RequestParam("tier") String tier) throws SQLException {
        user.setTier(tier);

        //check if the username already exists
        String query = String.format("SELECT * FROM accounts WHERE username = '{%s}'", user.getUser());
        ResultSet results = DatabaseConnection.executeQuery(query);
        boolean goodUser = DatabaseConnection.isEmptySet(results);

        //if its a good username, insert new user into accounts
        if (goodUser){
            query = String.format("INSERT INTO users (\"first\", \"last\", \"username\", \"password\", \"tier\", \"email\") VALUES ('{%s}', '{%s}', '{%s}', '{%s}', '{%s}', '{%s}')",user.getFirst(), user.getLast(), user.getUser(), user.getPass(), user.getTier(), user.getEmail());
            DatabaseConnection.executeUpdate(query);
            return "home";
        } else {
            return "login_error";
        }
    }
}
