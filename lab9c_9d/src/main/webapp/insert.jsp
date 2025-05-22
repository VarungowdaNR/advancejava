<%@ page import="java.sql.*" %>
<%
    String message = "";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int grandTotal = 0;

    String empNoStr = request.getParameter("empno");
    String empName = request.getParameter("empname");
    String basicSalaryStr = request.getParameter("basicsalary");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "");

        if(empNoStr != null && empName != null && basicSalaryStr != null) {
            int empNo = Integer.parseInt(empNoStr);
            int basicSalary = Integer.parseInt(basicSalaryStr);

            String insertQuery = "INSERT INTO empp (Emp_No, Emp_Name, BasicSalary) VALUES (?, ?, ?)";
            ps = con.prepareStatement(insertQuery);
            ps.setInt(1, empNo);
            ps.setString(2, empName);
            ps.setInt(3, basicSalary);
            ps.executeUpdate();
            ps.close();

            message = "Employee inserted successfully!";
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
<form action="insert.jsp" method="post">
    Emp No: <input type="text" name="empno" required><br>
    Emp Name: <input type="text" name="empname" required><br>
    Basic Salary: <input type="text" name="basicsalary" required><br>
    <input type="submit" value="Add Employee">
</form>

<p><%= message %></p>
