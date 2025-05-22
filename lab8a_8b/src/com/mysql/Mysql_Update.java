package com.mysql;

import java.sql.*;
import java.util.Properties;

public class Mysql_Update {
    public static void main(String[] args) {
        Connection dbConnection = null;

        try {
            // Load JDBC Driver (optional but recommended)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Change the URL to your actual database name, e.g. "coffee"
            String url = "jdbc:mysql://localhost:3306/coffee?useSSL=false&serverTimezone=UTC";

            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "");  // your password here

            dbConnection = DriverManager.getConnection(url, info);

            if (dbConnection != null) {
                System.out.println("✅ Successfully connected to MySQL database 'coffee'");

                // Select query
                String selectQuery = "SELECT * FROM coffee";
                Statement st = dbConnection.createStatement();
                ResultSet rs = st.executeQuery(selectQuery);

                System.out.println("\n☕ Coffee Records before update:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String coffeeName = rs.getString("coffee_name");
                    int price = rs.getInt("price");
                    System.out.format("%d %s %d%n", id, coffeeName, price);
                }
                rs.close();
                st.close();

                // Update query
                String updateQuery = "UPDATE coffee SET price = ? WHERE id = ?";
                PreparedStatement preparedStmt = dbConnection.prepareStatement(updateQuery);
                preparedStmt.setInt(1, 950);
                preparedStmt.setInt(2, 102);  // change id as needed

                int rowsUpdated = preparedStmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("\n✅ Record updated successfully.");
                } else {
                    System.out.println("\n⚠️ No record found with id=102 to update.");
                }
                preparedStmt.close();

                // Optionally, show updated data
                Statement st2 = dbConnection.createStatement();
                ResultSet rs2 = st2.executeQuery(selectQuery);

                System.out.println("\n☕ Coffee Records after update:");
                while (rs2.next()) {
                    int id = rs2.getInt("id");
                    String coffeeName = rs2.getString("coffee_name");
                    int price = rs2.getInt("price");
                    System.out.format("%d %s %d%n", id, coffeeName, price);
                }
                rs2.close();
                st2.close();

            } else {
                System.out.println("❌ Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.err.println("❌ SQL Exception:");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("❌ JDBC Driver not found:");
            e.printStackTrace();
        } finally {
            // Close connection safely
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
