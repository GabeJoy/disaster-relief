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
        model.addAttribute("request_item", new Request());
        return "make-request";
    }

    @PostMapping("/request")
    public String processRequest(@ModelAttribute Request requestItem, Principal principal) throws SQLException {
        requestItem.setRequester(principal.getName()); //get username associated with request

        List<String> recipient_info = extractInfo(DatabaseConnection.executeQuery(String.format("select city, state, country from users where username = '%s'", principal.getName())));
        requestItem.setCity(recipient_info.get(0));
        requestItem.setState(recipient_info.get(1));
        requestItem.setCountry(recipient_info.get(2));

        String query = String.format("INSERT INTO requests (\"item\", \"requester\", \"reason\", \"amount\", \"city\", \"state\", \"country\") VALUES ('%s', '%s', '%s', '%d', '%s', '%s', '%s')", requestItem.getItem(), requestItem.getRequester(), requestItem.getReason(), Integer.parseInt(requestItem.getAmount()), requestItem.getCity(), requestItem.getState(), requestItem.getCountry());
        DatabaseConnection.executeUpdate(query);
        return "request_success";
    }

    private List<String> extractInfo(ResultSet results) throws SQLException {
        List<String> results_arr = new ArrayList<>();
        ResultSetMetaData rsmd = results.getMetaData();

        int columnsNumber = rsmd.getColumnCount();
        while (results.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                results_arr.add(results.getString(i));
            }
        }

        return results_arr;
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
            requests.add(new Request(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6), row.get(7)));
        }

        return requests;
    }
}
