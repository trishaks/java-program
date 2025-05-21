<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Coffee Products Starting with 'D'</title>
</head>
<body>
    <h1>List of Coffee Products Starting with 'D'</h1>

    <%
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = ""; // Replace with your MySQL password

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM coffee WHERE coffee_name LIKE 'D%'";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Coffee Name</th><th>Price</th></tr>");

            boolean found = false;
            while (rs.next()) {
                found = true;
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("coffee_name") + "</td>");
                out.println("<td>" + rs.getDouble("price") + "</td>");
                out.println("</tr>");
            }

            if (!found) {
                out.println("<tr><td colspan='3'>No coffee products starting with 'D' found.</td></tr>");
            }

            out.println("</table>");

        } catch (Exception e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    %>
</body>
</html>
