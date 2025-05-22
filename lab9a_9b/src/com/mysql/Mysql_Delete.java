package com.mysql;

import java.sql.*;
import java.util.Properties;

public class Mysql_Delete {
    public static void main(String[] args) {
        Connection dbConnection = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement preparedStmt2 = null;

        try {
            // Load driver (optional but recommended)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the 'coffee' database (adjust if needed)
            String url = "jdbc:mysql://localhost:3306/coffee?useSSL=false&serverTimezone=UTC";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", ""); // your password here

            dbConnection = DriverManager.getConnection(url, info);

            if (dbConnection != null) {
                System.out.println("✅ Successfully connected to MySQL database 'coffee'");

                // Display existing records before deletion
                String selectQuery = "SELECT * FROM coffee";
                st = dbConnection.createStatement();
                rs = st.executeQuery(selectQuery);

                System.out.println("\n☕ Coffee Records before deletion:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String coffeeName = rs.getString("coffee_name");
                    int price = rs.getInt("price");
                    System.out.format("%d, %s, %d%n", id, coffeeName, price);
                }

                // Delete record with id=264
                String deleteQuery = "DELETE FROM coffee WHERE id = ?";
                preparedStmt2 = dbConnection.prepareStatement(deleteQuery);
                preparedStmt2.setInt(1, 264);

                int rowsDeleted = preparedStmt2.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("\n✅ Record with id=264 deleted successfully.");
                } else {
                    System.out.println("\n⚠️ No record found with id=264 to delete.");
                }

                // Display records after deletion
                rs.close();
                st.close();

                st = dbConnection.createStatement();
                rs = st.executeQuery(selectQuery);

                System.out.println("\n☕ Coffee Records after deletion:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String coffeeName = rs.getString("coffee_name");
                    int price = rs.getInt("price");
                    System.out.format("%d, %s, %d%n", id, coffeeName, price);
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ SQL Exception:");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("❌ JDBC Driver not found:");
            e.printStackTrace();
        } finally {
            // Close all resources
            try {
                if (preparedStmt2 != null) preparedStmt2.close();
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
