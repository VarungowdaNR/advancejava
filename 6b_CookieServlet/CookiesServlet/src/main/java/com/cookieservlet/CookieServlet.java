//6b. Build a servlet program to create a cookie to get your name through text box and press submit
//button( through HTML) to display the message by greeting Welcome back your name ! , you have
//visited this page n times ( n = number of your visit ) and demonstrate the expiry of cookie also.


package com.cookieservlet;

//Step 1: Required imports
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Step 2: Servlet Annotation
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

 int count = 0;

 // Step 3: doGet method
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {

     response.setContentType("text/html");
     PrintWriter out = response.getWriter();

     // Step 4: Get user input
     String userName = request.getParameter("username");

     if (userName != null && !userName.trim().isEmpty()) {
         // Step 5: Encode user name to avoid space issues
         String encodedName = URLEncoder.encode(userName, "UTF-8");

         // Step 6: Create new cookie
         Cookie userCookie = new Cookie("user", encodedName);

         // Step 7: Set cookie properties
         userCookie.setMaxAge(60); // 1 minute expiry
         userCookie.setPath("/");

         // Step 8: Add cookie to response
         response.addCookie(userCookie);
     }

     // Step 9: Read existing cookies
     Cookie[] cookies = request.getCookies();
     String existingUser = null;

     if (cookies != null) {
         for (Cookie cookie : cookies) {
             if (cookie.getName().equals("user")) {
                 existingUser = URLDecoder.decode(cookie.getValue(), "UTF-8");
             }
         }
     }

     // Step 10: Display the user name
     if (existingUser != null) {
         out.println("<h2>Welcome back, " + existingUser + "!</h2>");
     } else {
         out.println("<h2>Hello, new user!</h2>");
     }

     out.close();
 }

 // Step 11: doPost delegates to doGet
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
     doGet(request, response);
 }
}
