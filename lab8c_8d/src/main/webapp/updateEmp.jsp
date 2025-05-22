<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head><title>Update Employee</title></head>
<body>
    <h2>Update Employee</h2>
    <form action="updateEmpAction.jsp" method="post">
        Emp No (to update): <input type="text" name="empno" required><br>
        New Name: <input type="text" name="empname" required><br>
        New Basic Salary: <input type="text" name="basicsalary" required><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
