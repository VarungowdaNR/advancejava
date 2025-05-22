package com.mysql;

import java.sql.*;
import java.util.Properties;

public class Mysql_Query {
    public static void main(String[] args) {
        Connection dbConnection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // Load JDBC Driver explicitly
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the 'coffee' database (adjust if needed)
            String url = "jdbc:mysql://localhost:3306/coffee?useSSL=false&serverTimezone=UTC";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "");  // your password here

            dbConnection = DriverManager.getConnection(url, info);

            if (dbConnection != null) {
                System.out.println("✅ Successfully connected to MySQL database 'coffee'");

                // Your SELECT query filtering coffee_name starting with 'D'
                String query = "SELECT * FROM coffee WHERE coffee_name LIKE 'D%'";

                st = dbConnection.createStatement();
                rs = st.executeQuery(query);

                System.out.println("\n☕ Coffee items starting with 'D':");
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    int id = rs.getInt("id");
                    String coffeeName = rs.getString("coffee_name");
                    int price = rs.getInt("price");
                    System.out.format("%d %s %d%n", id, coffeeName, price);
                }
                if (!found) {
                    System.out.println("No coffee items found starting with 'D'");
                }
            } else {
                System.out.println("❌ Failed to connect to database.");
            }

        } catch (SQLException e) {
            System.err.println("❌ SQL Exception:");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("❌ JDBC Driver not found:");
            e.printStackTrace();
        } finally {
            // Close resources safely
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
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
