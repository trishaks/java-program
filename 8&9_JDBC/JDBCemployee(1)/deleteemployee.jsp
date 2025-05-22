<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Delete Employee</title>
</head>
<body>
    <h2>Delete Employee Record</h2>

    <form method="post" action="deleteEmployee.jsp">
        Enter Employee ID to Delete: <input type="text" name="empid" required />
        <input type="submit" value="Delete" />
    </form>

<%
    // Get the employee ID parameter from the form
    String empIdStr = request.getParameter("empid");

    if (empIdStr != null && !empIdStr.trim().isEmpty()) {
        try {
            int empId = Integer.parseInt(empIdStr.trim());

            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the Employee database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");

            // Prepare DELETE statement
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Emp WHERE Emp_NO = ?");
            pstmt.setInt(1, empId);

            // Execute DELETE query
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                out.println("<p style='color:green;'>Employee with ID " + empId + " deleted successfully.</p>");
            } else {
                out.println("<p style='color:red;'>Employee with ID " + empId + " not found.</p>");
            }

            // Close resources
            pstmt.close();
            conn.close();

        } catch (NumberFormatException nfe) {
            out.println("<p style='color:red;'>Invalid Employee ID format. Please enter a valid number.</p>");
        } catch (Exception e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        }
    }
%>
</body>
</html>
