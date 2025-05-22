<%@ page import="java.sql.*" %>
<%
    String empno = request.getParameter("empno");
    String empname = request.getParameter("empname");
    String basicsalary = request.getParameter("basicsalary");

    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    int totalSalary = 0;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/Employee", "root", "");

        // Insert the record
        String insertSQL = "INSERT INTO Empp (Emp_No, Emp_Name, BasicSalary) VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(insertSQL);
        pstmt.setInt(1, Integer.parseInt(empno));
        pstmt.setString(2, empname);
        pstmt.setInt(3, Integer.parseInt(basicsalary));
        pstmt.executeUpdate();

        // Display report
        out.println("<h2>Salary Report</h2>");
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");

        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM Empp");

        while (rs.next()) {
            int id = rs.getInt("Emp_No");
            String name = rs.getString("Emp_Name");
            int salary = rs.getInt("BasicSalary");

            out.println("Emp_No : " + id + "<br>");
            out.println("Emp_Name: " + name + "<br>");
            out.println("Basic : " + salary + "<br>");
            out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");

            totalSalary += salary;
        }

        out.println("<strong>Grand Salary : " + totalSalary + "</strong><br>");
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    } catch (Exception e) {
        out.println("<h3>Error: " + e.getMessage() + "</h3>");
    } finally {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>
