package com.example.demo.Controllers;

import com.example.demo.DatabaseConnection;
import com.example.demo.Models.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
//@PreAuthorize("hasRole('Administrator')")
public class AdminController {

    @GetMapping(value="")
    public String getAdmin(){
        return "admin";
    }

    @GetMapping("/view-requests")
    public String viewRequests(Model model) throws SQLException {
        model.addAttribute("requests", getRequests());
        return "view-requests";
    }

    @GetMapping("/process-requests")
    public String processRequests(Model model) throws SQLException {
        model.addAttribute("requests", getRequests());
        return "process-requests";
    }

    private List<Request> getRequests() throws SQLException {
        ResultSet results = DatabaseConnection.executeQuery("select * from requests");
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
