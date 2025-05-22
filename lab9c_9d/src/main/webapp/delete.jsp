<%@ page import="java.sql.*" %>
<%
    String message = "";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int grandTotal = 0;

    String deletePrefix = request.getParameter("prefix");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "");

        if(deletePrefix != null && !deletePrefix.trim().isEmpty()) {
            String deleteQuery = "DELETE FROM empp WHERE Emp_Name LIKE ?";
            ps = con.prepareStatement(deleteQuery);
            ps.setString(1, deletePrefix + "%");
            int deletedCount = ps.executeUpdate();
            ps.close();

            message = deletedCount + " employee(s) deleted whose name starts with '" + deletePrefix + "'";
        }

        // Now display the report
        out.println("<h2>Salary Report</h2>");
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");

        String selectQuery = "SELECT * FROM empp";
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(selectQuery);

        while(rs.next()) {
            int id = rs.getInt("Emp_No");
            String name = rs.getString("Emp_Name");
            int salary = rs.getInt("BasicSalary");
            grandTotal += salary;

            out.println("Emp_No : " + id + "<br>");
            out.println("Emp_Name: " + name + "<br>");
            out.println("Basic : " + salary + "<br>");
            out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");
        }
        out.println("<b>Grand Salary : " + grandTotal + "</b><br>");

        rs.close();
        stmt.close();
        con.close();

    } catch(Exception e) {
        out.println("<b>Error: </b>" + e.getMessage());
    }
%>

<hr>
<form action="delete.jsp" method="post">
    Delete employees whose names start with: <input type="text" name="prefix" required maxlength="1"><br>
    <input type="submit" value="Delete Employees">
</form>

<p><%= message %></p>
