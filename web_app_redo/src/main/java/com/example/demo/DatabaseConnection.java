package com.example.demo;
import com.example.demo.Models.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/Disaster_Relief";
        String username = "postgres";
        String password = "postgres";
        return DriverManager.getConnection(url, username, password);
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        Connection db = DatabaseConnection.getConnection();
        db.prepareStatement(query);
        Statement statement = db.createStatement();
        return statement.executeQuery(query);
    }

    public static void executeUpdate(String query) throws SQLException {
        Connection db = DatabaseConnection.getConnection();
        db.prepareStatement(query);
        Statement statement = db.createStatement();
        statement.executeUpdate(query);
    }

    public static void printResultSet(ResultSet results) throws SQLException {
        ResultSetMetaData rsmd = results.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (results.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = results.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }

    public static boolean isEmptySet(ResultSet results) throws SQLException {
        return (!results.isBeforeFirst() && results.getRow() == 0);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        String query = "SELECT * FROM users;";
//        Class.forName("org.postgresql.Driver");
//        Connection db = DatabaseConnection.getConnection();
//        db.prepareStatement(query);
//        Statement statement = db.createStatement();
//        ResultSet results = statement.executeQuery(query);
//        System.out.println(!(!results.isBeforeFirst() && results.getRow() == 0));
//        printResultSet(results);

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
       // System.out.println(new BCryptPasswordEncoder().encode("password"));
    }
}
