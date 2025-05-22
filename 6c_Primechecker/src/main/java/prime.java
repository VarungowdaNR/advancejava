//6c. Build a servlet program to check the given number is prime number or not using HTML with step
//by step procedure.


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prime")
public class prime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int number = Integer.parseInt(request.getParameter("number"));
            boolean isPrime = true;

            if (number <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= number / 2; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            out.println("<html><head><title>Prime Number Checker</title></head><body>");
            out.println("<div style='margin: 20px; padding: 20px; border: 1px solid #ccc;'>");
            out.println("<h2>Prime Number Checker Result</h2>");
            out.println("<p>Entered Number: " + number + "</p>");
            if (isPrime) {
                out.println("<p><strong>" + number + "</strong> is a Prime Number.</p>");
            } else {
                out.println("<p><strong>" + number + "</strong> is <b>not</b> a Prime Number.</p>");
            }
            out.println("<a href='prime.html'>Check Another Number</a>");
            out.println("</div></body></html>");

        } catch (NumberFormatException e) {
            out.println("<html><body><p>Error: Please enter a valid integer.</p></body></html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("prime.html");
    }
}