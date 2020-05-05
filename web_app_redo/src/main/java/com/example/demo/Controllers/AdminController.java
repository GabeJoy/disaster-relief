package com.example.demo.Controllers;

import com.example.demo.DatabaseConnection;
import com.example.demo.Models.Request;
import com.example.demo.Models.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        model.addAttribute("responses", getResponses());
        return "process-requests";
    }

    private List<Request> getRequests() throws SQLException {
        ResultSet results = DatabaseConnection.executeQuery("select * from requests;");
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

    @PostMapping("/process-requests")
    public String makeMatch(@RequestParam("request_id") String request_id, @RequestParam("pledge_id") String pledge_id) throws SQLException {
        ResultSet request_info = DatabaseConnection.executeQuery(String.format("select * from requests where id = %d", Integer.parseInt(request_id)));
        ResultSet pledge_info = DatabaseConnection.executeQuery(String.format("select * from responses where id = %d", Integer.parseInt(pledge_id)));

        System.out.println(request_id + " " + pledge_id);
//        DatabaseConnection.printResultSet(request_info);
//        DatabaseConnection.printResultSet(pledge_info);

        if (DatabaseConnection.isEmptySet(request_info) || DatabaseConnection.isEmptySet(pledge_info)){
            return "match-error";
        } else {
            String requester = request_info.getString(3);
            String donor = pledge_info.getString(2);
            String item = request_info.getString(2);
            int amount = Integer.parseInt(pledge_info.getString(4));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(new Date());

            DatabaseConnection.executeUpdate(String.format("insert into transactions (\"recipient\", \"sender\", \"item\", \"amount\", \"date\") values ('%s', '%s', '%s', '%d', '%s')", requester, donor, item, amount, date));
//            DatabaseConnection.executeUpdate(String.format("delete from requests where id = %d;", Integer.parseInt(request_info.getString(1))));
//            DatabaseConnection.executeUpdate(String.format("delete from responses where id = %d;", Integer.parseInt(pledge_info.getString(1))));

            return "match-success";
        }
    }

    private List<Response> getResponses() throws SQLException {
        String query = "select * from responses;";
        ResultSet results = DatabaseConnection.executeQuery(query);
        ResultSetMetaData rsmd = results.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        List<Response> responses = new ArrayList<>();
        while (results.next()) {
            ArrayList<String> row = new ArrayList<>();
            for (int i = 1; i <= columnsNumber; i++) {
                row.add(results.getString(i));
            }
            responses.add(new Response(row.get(0), row.get(1), row.get(2), Integer.parseInt(row.get(3)), row.get(4), row.get(5), row.get(6), row.get(7)));
        }

        return responses;
    }
}
