<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="java.io.*" %>
<html>
<head>
    <title>Add Cookie</title>
</head>
<body>
    <h2>Cookie Management</h2>
    <form method="post">
        Name: <input type="text" name="cname" required><br><br>
        Domain: <input type="text" name="cdomain" required><br><br>
        Max Age (in seconds): <input type="number" name="cage" required><br><br>
        <input type="submit" value="Add Cookie">
    </form>

<%
    String name = request.getParameter("cname");
    String domain = request.getParameter("cdomain");
    String ageStr = request.getParameter("cage");

    if(name != null && domain != null && ageStr != null) {
        int age = Integer.parseInt(ageStr);
        Cookie cookie = new Cookie(name, domain);
        cookie.setMaxAge(age);
        response.addCookie(cookie);
%>
    <h3>Cookie Set Successfully!</h3>
    <p><strong>Name:</strong> <%= name %></p>
    <p><strong>Domain (as Value):</strong> <%= domain %></p>
    <p><strong>Max Age:</strong> <%= age %> seconds</p>
<%
    }
%>
    <br>
    <a href="showCookies.jsp">Go to the active cookie list</a>
</body>
</html>
<%@ page import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>Active Cookies</title>
</head>
<body>
    <h2>Active Cookie List</h2>
    <%
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
    %>
        <table border="1">
            <tr>
                <th>Cookie Name</th>
                <th>Value</th>
            </tr>
            <%
                for (Cookie c : cookies) {
            %>
            <tr>
                <td><%= c.getName() %></td>
                <td><%= c.getValue() %></td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <p>No active cookies found.</p>
    <%
        }
    %>
    <br><br>
    <a href="addCookie.jsp">Back to Add Cookie</a>
</body>
</html>
