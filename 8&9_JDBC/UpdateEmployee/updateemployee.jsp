<%@ page import="java.sql.*" %>
<%
    String empno = request.getParameter("empno");
    String empname = request.getParameter("empname");
    String basicsalary = request.getParameter("basicsalary");

    try {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connect to the database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");

        // Prepare the SQL update statement
        String query = "UPDATE Emp SET Emp_Name = ?, Basicsalary = ? WHERE Emp_NO = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, empname);
        pstmt.setDouble(2, Double.parseDouble(basicsalary));
        pstmt.setInt(3, Integer.parseInt(empno));

        int rowsUpdated = pstmt.executeUpdate();

        if (rowsUpdated > 0) {
            out.println("<p style='color:green;'>Employee details updated successfully!</p>");
        } else {
            out.println("<p style='color:red;'>No employee found with the given Employee Number.</p>");
        }

        conn.close();
    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    }
%>
<a href="updateForm.jsp">Go Back to Form</a>
