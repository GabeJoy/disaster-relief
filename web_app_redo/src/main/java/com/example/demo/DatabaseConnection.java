package com.example.demo;
import java.sql.*;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/Disaster_Relief";
        String username = "postgres";
        String password = "postgres";
        return DriverManager.getConnection(url, username, password);
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM users WHERE username = '{joe}' AND password = '{pass}' AND tier = '{Administrator}';";
        Class.forName("org.postgresql.Driver");
        Connection db = DatabaseConnection.getConnection();
        db.prepareStatement(query);
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery(query);
        System.out.println(!(!results.isBeforeFirst() && results.getRow() == 0));
        printResultSet(results);
    }
}
