package com.example.demo.Controllers;

import com.example.demo.DatabaseConnection;
import com.example.demo.Request;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.crypto.Data;
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
//        model.addAttribute("users", DatabaseConnection.executeQuery("select * from requests"));
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
        model.addAttribute("requests", requests);

        return "view-requests";
    }

    @GetMapping("/match-requests")
    public String matchRequests(){
        return "match-requests";
    }
}
