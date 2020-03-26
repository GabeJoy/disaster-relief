package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
@RequestMapping("/user")
public class LoginController {

    @GetMapping(value="/login")
    public String getForm(Model model){
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping(value = "/login")
    public String authenticate(@ModelAttribute Login login, @RequestParam("tier") String tier) throws SQLException {
        login.setTier(tier);
        if (authenticateUser(login)){
            return "home";
        } else {
            return "login_error";
        }
    }

    @GetMapping(value = "/home")
    public String getHome(){
        return "home";
    }

    private boolean authenticateUser(Login login) throws SQLException {
        String query = String.format("SELECT * FROM users WHERE username = '{%s}' AND password = '{%s}' AND tier = '{%s}';", login.getUser(), login.getPass(), login.getTier());
        System.out.println(query);
        Connection db = DatabaseConnection.getConnection();
        db.prepareStatement(query);
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery(query);

        //if true, the result set isnt empty and user exists
        return !(!results.isBeforeFirst() && results.getRow() == 0);
    }
}