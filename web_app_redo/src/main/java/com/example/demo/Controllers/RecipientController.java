package com.example.demo.Controllers;

import com.example.demo.DatabaseConnection;
import com.example.demo.Models.Request;
import com.example.demo.Models.RequestItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/recipient"})
public class RecipientController {

    @GetMapping("")
    public String getRecipient(){
        return "recipient_home";
    }

    @GetMapping("see-requests")
    public String seeRequests(Model model, Principal principal) throws SQLException {
        model.addAttribute("requests", getRequests(principal.getName()));
        return "recipient-requests";
    }

    @PostMapping("see-requests")
    public String deleteRequest(@RequestParam("req_id") String request_id, Principal principal) throws SQLException {
        DatabaseConnection.executeUpdate(String.format("delete from requests where id = '%s' AND requester = '%s'", request_id, principal.getName()));
        return "recipient-requests";
    }

    @GetMapping("/request")
    public String getForm(Model model){
        model.addAttribute("request_item", new RequestItem());
        return "make-request";
    }

    @PostMapping("/request")
    public String processRequest(@ModelAttribute RequestItem requestItem, Principal principal) throws SQLException {
        requestItem.setUser_requesting_id(principal.getName()); //get username associated with request
        String query = String.format("INSERT INTO requests (\"item\", \"requester\", \"reason\", \"amount\") VALUES ('%s', '%s', '%s', '%s')", requestItem.getItem_name(), requestItem.getUser_requesting_id(), requestItem.getReason_needed(), requestItem.getAmount_needed());
        DatabaseConnection.executeUpdate(query);
        return "request_success";
    }

    private List<Request> getRequests(String username) throws SQLException {
        String query = String.format("select * from requests where requester = '%s'", username);
        ResultSet results = DatabaseConnection.executeQuery(query);
        ResultSetMetaData rsmd = results.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        List<Request> requests = new ArrayList<>();
        while (results.next()) {
            ArrayList<String> row = new ArrayList<>();
            for (int i = 1; i <= columnsNumber; i++) {
                row.add(results.getString(i));
            }
            requests.add(new Request(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4)));
        }

        return requests;
    }
}
