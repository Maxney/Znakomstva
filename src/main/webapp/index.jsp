<%@ page import="org.example.entity.Users" %>
<%@ page import="org.example.repository.UsersRepository" %><%--
  Created by IntelliJ IDEA.
  User: GUA
  Date: 13.03.2023
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Addition of Users</title>

    <!-- Section used as css styling for table -->
    <style>
        .css-styled-table {
            border-collapse: collapse;
            margin: 25px 0;
            font-size: 0.9em;
            font-family: sans-serif;
            min-width: 400px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
        }
        .css-styled-table thead tr {
            background-color: #009879;
            color: #ffffff;
            text-align: left;
        }
        .css-styled-table th,
        .css-styled-table td {
            padding: 12px 15px;
        }
        .css-styled-table tbody tr {
            border-bottom: 1px solid #dddddd;
        }

        .css-styled-table tbody tr:nth-of-type(even) {
            background-color: #f3f3f3;
        }

        .css-styled-table tbody tr:last-of-type {
            border-bottom: 2px solid #009879;
        }
        .css-styled-table tbody tr.active-row {
            font-weight: bold;
            color: #009879;
        }
    </style>

    <!-- Section used as css styling for table -->
</head>
<body>

<h1>Create New Users</h1>

<!-- SaveServlet is the servlet name that is looked up
     and POST is the method that got called -->
<form action="UsersServlet" method="post">
    <table class="css-styled-table">
        <tr><td>login: </td><td><input type="text" name="login"/></td></tr>
        <tr><td>password:</td><td><input type="text" name="numberOfPosts"/></td></tr>
        <tr><td>Age:</td><td><input type="text" name="technologiesPreferred"/></td></tr>
        <tr><td colspan="2"><input type="submit" value="Save GeekUser"/></td></tr>
    </table>
</form>

<br/>
<a href="ViewServlet">view Users</a>

</body>
</html>
