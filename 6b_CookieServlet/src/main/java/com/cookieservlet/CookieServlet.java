package com.cookieservlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        // Get existing cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;
        int visitCount = 0;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user".equals(cookie.getName())) {
                    existingUser = cookie.getValue();
                }
                if ("visitCount".equals(cookie.getName())) {
                    try {
                        visitCount = Integer.parseInt(cookie.getValue());
                    } catch (NumberFormatException e) {
                        visitCount = 0;
                    }
                }
            }
        }

        if (userName != null && !userName.trim().isEmpty()) {
            existingUser = userName;
            visitCount = 1; // new visit

            Cookie userCookie = new Cookie("user", userName);
            Cookie visitCookie = new Cookie("visitCount", Integer.toString(visitCount));

            userCookie.setMaxAge(60); // 1 minute expiry
            visitCookie.setMaxAge(60); // 1 minute expiry

            response.addCookie(userCookie);
            response.addCookie(visitCookie);
        } else if (existingUser != null) {
            visitCount++;
            Cookie visitCookie = new Cookie("visitCount", Integer.toString(visitCount));
            visitCookie.setMaxAge(60); // renew expiry
            response.addCookie(visitCookie);
        }

        // Generate HTML
        out.println("<html><head><title>Cookie Demo</title></head><body>");

        if (existingUser != null) {
            out.println("<h2 style='color:blue'>Welcome back, " + existingUser + "!</h2>");
            out.println("<h3 style='color:green'>You have visited this page " + visitCount + " times.</h3>");
            out.println("<form action='CookieServlet' method='post'>");
            out.println("<input type='submit' value='Clear Cookie (Logout)'>");
            out.println("</form>");
        } else {
            out.println("<h2>Welcome Guest!</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Enter your name: <input type='text' name='userName' required>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("<p><small>Note: Cookie expires in 60 seconds.</small></p>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Invalidate cookies
        Cookie userCookie = new Cookie("user", "");
        Cookie visitCookie = new Cookie("visitCount", "");
        userCookie.setMaxAge(0);
        visitCookie.setMaxAge(0);
        response.addCookie(userCookie);
        response.addCookie(visitCookie);
        response.sendRedirect("CookieServlet");
    }
}
