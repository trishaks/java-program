<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Delete Employees and Salary Report</title>
    <style>
        body {
            font-family: monospace;
        }
        .line {
            border-top: 1px solid #000;
            margin: 10px 0;
        }
    </style>
</head>
<body>
<h2>Delete Employees by Name Starting Letter and Generate Salary Report</h2>

<form method="post" action="deleteByNameStart.jsp">
    Enter starting letter: <input type="text" name="start" maxlength="1" required />
    <input type="submit" value="Delete and Generate Report" />
</form>

<%
    String start = request.getParameter("start");

    if (start != null && !start.trim().isEmpty()) {
        String letter = start.trim().toUpperCase();  // Normalize input

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");

            // First: Delete employees whose names start with the given letter
            PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM Emp WHERE Emp_Name LIKE ?");
            deleteStmt.setString(1, letter + "%");
            int deletedRows = deleteStmt.executeUpdate();

            out.println("<p style='color:blue;'>" + deletedRows + " employee(s) with names starting with '" + letter + "' deleted.</p>");

            // Second: Generate report of remaining employees
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Emp ORDER BY Emp_Name");
            ResultSet rs = ps.executeQuery();

            int grandTotal = 0;
%>
<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<%
            boolean hasRecords = false;
            while (rs.next()) {
                hasRecords = true;
                int no = rs.getInt("Emp_NO");
                String name = rs.getString("Emp_Name");
                int salary = rs.getInt("Basicsalary");
                grandTotal += salary;
%>
Emp_No    : <%= no %>  
Emp_Name  : <%= name %>  
Basic     : <%= salary %>  
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<%
            }

            if (!hasRecords) {
                out.println("No employee records found.");
            } else {
%>
Grand Total Salary = <%= grandTotal %>  
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<%
            }

            // Close resources
            rs.close();
            ps.close();
            deleteStmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        }
    }
%>

</body>
</html>
