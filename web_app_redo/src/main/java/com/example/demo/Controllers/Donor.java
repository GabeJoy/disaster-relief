package com.example.demo.Controllers;

import com.example.demo.DatabaseConnection;
import com.example.demo.Models.Response;
import com.example.demo.Models.User;
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
@RequestMapping({"/donor"})
public class Donor {

    @GetMapping("")
    public String getHome(){
        return "donor-home";
    }

    @GetMapping("/responses")
    public String getResponses(Model model, Principal principal) throws SQLException {
        model.addAttribute("responses", getPledges(principal.getName()));
        return "donor-responses";
    }

    @PostMapping("/responses")
    public String expirePledge(@RequestParam("response_id") String id, Principal principal, Model model) throws SQLException {
        System.out.println(id);
        DatabaseConnection.executeUpdate(String.format("delete from responses where id = '%s' AND username = '%s'", id, principal.getName()));
        model.addAttribute("responses", getPledges(principal.getName()));
        return "donor-responses";
    }

    private List<Response> getPledges(String username) throws SQLException {
        String query = String.format("select * from responses where username = '%s'", username);
        ResultSet results = DatabaseConnection.executeQuery(query);
        ResultSetMetaData rsmd = results.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        List<Response> responses = new ArrayList<>();
        while (results.next()) {
            ArrayList<String> row = new ArrayList<>();
            for (int i = 1; i <= columnsNumber; i++) {
                row.add(results.getString(i));
            }
            responses.add(new Response(row.get(0), row.get(1), row.get(2), Integer.parseInt(row.get(3)), row.get(4), row.get(5), row.get(6)));
        }

        return responses;
    }

    @GetMapping("/pledge")
    public String getPledge(Model model){
        model.addAttribute("response", new Response());
        return "donor-pledge";
    }

    @PostMapping("/pledge")
    public String makePledge(@ModelAttribute Response response, Principal principal) throws SQLException {
        response.setUsername(principal.getName());

        //ResultSet donor_info = DatabaseConnection.executeQuery(String.format("select * from users where username = '%s'", principal.getName()));
        //get donor's city and state
        List<String> donor_info = extractInfo(DatabaseConnection.executeQuery(String.format("select city, state, country from users where username = '%s'", principal.getName())));
        response.setCity(donor_info.get(0));
        response.setState(donor_info.get(1));
        response.setCountry(donor_info.get(2));

        String query = String.format("INSERT INTO responses (\"username\", \"item\", \"amount\", \"city\", \"state\", \"country\") VALUES ('%s', '%s', '%d', '%s', '%s', '%s')", response.getUsername(), response.getItem(), response.getAmount(), response.getCity(), response.getState(), response.getCountry());
        DatabaseConnection.executeUpdate(query);

        return "successful-pledge";
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
}
