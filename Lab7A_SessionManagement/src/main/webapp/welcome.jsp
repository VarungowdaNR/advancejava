<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Welcome Page</title></head>
<body>
<%
String name = request.getParameter("uname");
out.print("Welcome! " + name);
session.setAttribute("user", name);
session.setMaxInactiveInterval(60); // 1 minute
%>
<br>Your name has been stored in the session.
<br><a href="second.jsp">Display the value</a>
</body>
</html>
