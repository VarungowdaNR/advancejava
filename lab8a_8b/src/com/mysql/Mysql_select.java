package com.mysql;

import java.sql.*;
import java.util.Properties;

public class Mysql_select {
    public static void main(String[] args) {
        Connection dbConnection = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the 'coffee' database instead of 'test'
            String url = "jdbc:mysql://localhost:3306/coffee?useSSL=false&serverTimezone=UTC";

            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "");  // Put your MySQL password here

            dbConnection = DriverManager.getConnection(url, info);

            if (dbConnection != null) {
                System.out.println("✅ Successfully connected to MySQL database 'coffee'");

                // SELECT query
                String selectQuery = "SELECT * FROM coffee";
                Statement selectStmt = dbConnection.createStatement();
                ResultSet rs = selectStmt.executeQuery(selectQuery);

                System.out.println("\n☕ Coffee Records:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String coffeeName = rs.getString("coffee_name");
                    int price = rs.getInt("price");
                    System.out.printf(" - ID: %d | Name: %s | Price: %d%n", id, coffeeName, price);
                }
                rs.close();
                selectStmt.close();

                // INSERT operation
                String insertQuery = "INSERT INTO coffee (coffee_name, price) VALUES (?, ?)";
                PreparedStatement insertStmt = dbConnection.prepareStatement(insertQuery);
                insertStmt.setString(1, "Tajmahal");
                insertStmt.setInt(2, 950);
                int rowsInserted = insertStmt.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("\n✅ New coffee added successfully.");
                }

                insertStmt.close();
            } else {
                System.out.println("❌ Connection failed. Please check your database settings.");
            }

        } catch (SQLException ex) {
            System.err.println("❌ SQL Exception occurred:");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("❌ JDBC Driver not found:");
            ex.printStackTrace();
        } catch (Exception e) {
            System.err.println("❌ Unexpected exception:");
            e.printStackTrace();
        } finally {
            // Close connection
            try {
                if (dbConnection != null && !dbConnection.isClosed()) {
                    dbConnection.close();
                    System.out.println("\n🔒 Connection closed.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
