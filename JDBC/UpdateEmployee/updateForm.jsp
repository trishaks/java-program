<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Employee Record</title>
</head>
<body>
    <h2>Update Employee Details</h2>
    <form action="updateEmployee.jsp" method="post">
        <label for="empno">Employee Number:</label>
        <input type="text" id="empno" name="empno" required><br><br>

        <label for="empname">Employee Name:</label>
        <input type="text" id="empname" name="empname" required><br><br>

        <label for="basicsalary">Basic Salary:</label>
        <input type="text" id="basicsalary" name="basicsalary" required><br><br>

        <input type="submit" value="Update">
    </form>
</body>
</html>
