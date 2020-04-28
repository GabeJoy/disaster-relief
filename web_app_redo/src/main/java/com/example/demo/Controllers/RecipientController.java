package com.example.demo.Controllers;

import com.example.demo.DatabaseConnection;
import com.example.demo.Models.RequestItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.SQLException;

@Controller
@RequestMapping({"/recipient"})
public class RecipientController {

    @GetMapping("/request")
    public String getForm(Model model){
        model.addAttribute("request_item", new RequestItem());
        return "request";
    }

    @PostMapping("/request")
    public String processRequest(@ModelAttribute RequestItem requestItem, Principal principal) throws SQLException {
        requestItem.setUser_requesting_id(principal.getName()); //get username associated with request
        String query = String.format("INSERT INTO requests (\"item\", \"requester\", \"reason\", \"amount\") VALUES ('%s', '%s', '%s', '%s')", requestItem.getItem_name(), requestItem.getUser_requesting_id(), requestItem.getReason_needed(), requestItem.getAmount_needed());
        DatabaseConnection.executeUpdate(query);
        return "request_success";
    }
}
