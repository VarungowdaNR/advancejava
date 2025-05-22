<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head><title>Insert Employee</title></head>
<body>
    <h2>Insert Employee</h2>
    <form action="insertEmpAction.jsp" method="post">
        Emp No: <input type="text" name="empno" required><br>
        Emp Name: <input type="text" name="empname" required><br>
        Basic Salary: <input type="text" name="basicsalary" required><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
