//package com.example.demo;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Controller
//@RequestMapping({"/", "/user"})
//public class LoginController {
//
//    @GetMapping(value="/login")
//    public String getForm(Model model){
//        model.addAttribute("login", new Login());
//        return "login";
//    }
//
//    @PostMapping(value = "/login")
//    public String authenticate(@ModelAttribute Login login, @RequestParam("tier") String tier) throws SQLException {
//        login.setTier(tier);
//        if (authenticateUser(login)){
//            return "home";
//        } else {
//            return "login_error";
//        }
//    }
//
//    @GetMapping(value = "/home")
//    public String getHome(){
//        return "home";
//    }
//
//    @GetMapping(value = "/newuser")
//    public String getNewUser(Model model){
//        model.addAttribute("user", new User());
//        return "newuser";
//    }
//
//    @PostMapping(value = "/newuser")
//    public String addNewUser(@ModelAttribute User user, @RequestParam("tier") String tier) throws SQLException {
//        user.setTier(tier);
//
//        //check if the username already exists
//        String query = String.format("SELECT * FROM accounts WHERE username = '{%s}'", user.getUser());
//        ResultSet results = DatabaseConnection.executeQuery(query);
//        boolean goodUser = DatabaseConnection.isEmptySet(results);
//
//        //if its a good username, insert new user into accounts
//        if (goodUser){
//            query = String.format("INSERT INTO accounts (\"first\", \"last\", \"username\", \"password\", \"tier\", \"email\") VALUES ('{%s}', '{%s}', '{%s}', '{%s}', '{%s}', '{%s}')",user.getFirst(), user.getLast(), user.getUser(), user.getPass(), user.getTier(), user.getEmail());
//            DatabaseConnection.executeUpdate(query);
//            return "home";
//        } else {
//            return "login_error";
//        }
//    }
//
//    private boolean authenticateUser(Login login) throws SQLException {
//        String query = String.format("SELECT * FROM accounts WHERE username = '{%s}' AND password = '{%s}' AND tier = '{%s}';", login.getUser(), login.getPass(), login.getTier());
//        ResultSet results = DatabaseConnection.executeQuery(query);
//        return !DatabaseConnection.isEmptySet(results); //if true, the result set isn't empty and user exists
//    }
//}