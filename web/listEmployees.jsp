<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%--<%@ page import="model.Employee" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        a {
            text-decoration: none;
            color: #007BFF;
        }
        a:hover {
            text-decoration: underline;
        }
        .add-btn {
            display: inline-block;
            padding: 10px 15px;
            margin-bottom: 20px;
            background-color: #28a745;
            color: #fff;
            border-radius: 5px;
            text-decoration: none;
        }
        .add-btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h1>Employee List</h1>
    <a href="addEmployee.jsp" class="add-btn">Add Employee</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Salary</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
                <tr>
                    <td>ID</td>
                    <td>name</td>
                    <td>email</td>
                    <td>salary</td>
<!--                    <td>
                        <a href="updateEmployee.jsp?id=${employee.id}">Edit</a> |
                        <a href="deleteEmployee?id=${employee.id}" onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>
                    </td>-->
                </tr>
        </tbody>
    </table>
</body>
</html>
