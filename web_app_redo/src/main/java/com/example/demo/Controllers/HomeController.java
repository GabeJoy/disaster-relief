package com.example.demo.Controllers;

import com.example.demo.DatabaseConnection;
import com.example.demo.Models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/403")
    public String get403(){
        return "403";
    }

    @GetMapping(value = "/newuser")
    public String getNewUser(Model model){
        model.addAttribute("user", new User());
        return "newuser";
    }

    @PostMapping(value = "/newuser")
    public String addNewUser(@ModelAttribute User user, @RequestParam("tier") String tier, @RequestParam("state") String state) throws SQLException {
        user.setTier(tier);
        user.setState(state);

        //check if the username already exists
        String query = String.format("SELECT * FROM users WHERE username = '%s'", user.getUser());
        ResultSet results = DatabaseConnection.executeQuery(query);
        boolean goodUser = DatabaseConnection.isEmptySet(results);

        //if its a good username, insert new user into accounts
        if (goodUser){
            query = String.format("INSERT INTO users (\"first\", \"last\", \"username\", \"password\", \"tier\", \"email\", \"enabled\", \"city\", \"state\", \"country\") VALUES ('%s', '%s', '%s', '%s', '%s', '%s', true, '%s', '%s', '%s')",user.getFirst(), user.getLast(), user.getUser(), new BCryptPasswordEncoder().encode(user.getPass()), user.getTier(), user.getEmail(), user.getCity(), user.getState(), user.getCountry());
            DatabaseConnection.executeUpdate(query);
            return "successful-account-creation";
        } else {
            return "login_error";
        }
    }
}
