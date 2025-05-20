Step by step implementation procedure:
 Create a new Dynamic Web Project:
o Open Eclipse
o File → New → Dynamic Web Project
o Name it "FactorialCalculatorDemo"
o Choose Apache Tomcat as the target runtime
o Click Finish

 Create the Servlet:
o Right-click on src folder
o New → Class
o Name it "FactorialServlet"
o Copy the Java code from the second artifact above
o Save the file
  
package com.factorial;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/factorial")
public class FactorialServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
try {

// Get the number from the form
int number = Integer.parseInt(request.getParameter("number"));
// Validate the input
if (number < 0) {
throw new IllegalArgumentException("Number cannot be negative");
}
if (number > 20) {
throw new IllegalArgumentException("Number too large, maximum allowed is 20");
}
// Calculate factorial
long factorial = 1;
String calculation = "Calculation steps:<br>";
if (number == 0 || number == 1) {
factorial = 1;
calculation += number + "! = 1";
} else {
calculation += number + "! = " + number;
for (int i = number; i >= 1; i--) {
factorial *= i;
if (i != number) {
calculation += " × " + i;
}
}
calculation += " = " + factorial;
}
// Generate the response
out.println("<html>");
out.println("<head>");
out.println("<title>Factorial Result</title>");
out.println("<style>");
out.println(".container { margin: 20px; padding: 20px; width: 500px; border: 1px solid #ccc;
border-radius: 5px; }");
out.println(".result { margin: 10px 0; }");
out.println("</style>");
out.println("</head>");
out.println("<body>");
out.println("<div class='container'>");
out.println("<h2>Factorial Result</h2>");

out.println("<div class='result'>");
out.println("<p>Number: " + number + "</p>");
out.println("<p>Factorial: " + factorial + "</p>");
out.println("<p>" + calculation + "</p>");
out.println("</div>");
out.println("<a href='index.html'>Calculate Another Factorial</a>");
out.println("</div>");
out.println("</body>");
out.println("</html>");
} catch (NumberFormatException e) {
displayError(out, "Please enter a valid number");
} catch (IllegalArgumentException e) {
displayError(out, e.getMessage());
}
}
private void displayError(PrintWriter out, String message) {
out.println("<html>");
out.println("<head><title>Error</title></head>");
out.println("<body>");
out.println("<div style='margin: 20px; color: red;'>");
out.println("<h2>Error</h2>");
out.println("<p>" + message + "</p>");
out.println("<a href='index.html'>Try Again</a>");
out.println("</div>");
out.println("</body>");
out.println("</html>");
}
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.sendRedirect("index.html");
}
}

Create the HTML file:

o Right-click on WebContent folder
o New → HTML File
o Name it "index.html"
  
<!DOCTYPE html>
<html>
<head>
<title>Factorial Calculator</title>
<style>
.container {
margin: 20px;
padding: 20px;
width: 300px;
border: 1px solid #ccc;
border-radius: 5px;
}
.form-group {
margin: 10px 0;
}
</style>
</head>
<body>
<div class="container">
<h2>Factorial Calculator</h2>
<form action="factorial" method="post">
<div class="form-group">
Enter a number:
<input type="number" name="number" min="0" max="20" required>
<small>(Max: 20)</small>
</div>
<input type="submit" value="Calculate Factorial">
</form>
</div>
</body>
</html>
