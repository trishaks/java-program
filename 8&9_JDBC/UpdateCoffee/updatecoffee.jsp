<%@ page import="java.sql.*" %>
<%
    String url = "jdbc:mysql://localhost:3306/test";
    String username = "root";
    String password = ""; // Replace with your MySQL password
 
    Connection conn = null;
    PreparedStatement psUpdate = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);

        String idStr = request.getParameter("id");
        String name = request.getParameter("coffee_name");
        String priceStr = request.getParameter("price");

        if (idStr != null && name != null && priceStr != null) {
            int id = Integer.parseInt(idStr);
            double price = Double.parseDouble(priceStr);

            String updateQuery = "UPDATE coffee SET coffee_name = ?, price = ? WHERE id = ?";
            psUpdate = conn.prepareStatement(updateQuery);
            psUpdate.setString(1, name);
            psUpdate.setDouble(2, price);
            psUpdate.setInt(3, id);

            int rows = psUpdate.executeUpdate();
            if (rows > 0) {
                out.println("<p>Coffee product updated successfully.</p>");
            } else {
                out.println("<p>No product found with the given ID.</p>");
            }
        }

        // Display all records
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM coffee");

        out.println("<h2>All Coffee Products</h2>");
        out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Price</th></tr>");
        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("coffee_name") + "</td>");
            out.println("<td>" + rs.getDouble("price") + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");

    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (psUpdate != null) psUpdate.close(); } catch (Exception e) {}
        try { if (stmt != null) stmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>
