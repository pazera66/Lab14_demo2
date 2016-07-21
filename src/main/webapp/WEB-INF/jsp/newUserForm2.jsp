<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!--#include virtual="navbar.jsp" -->
<html>
<head>

    <style>
        table, th, td {
            border: 5px solid black;
            border-collapse: collapse;
        }



        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            width: 200px;
            background-color: #f1f1f1;
        }

        li a {
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
        }

        li a.active {
            background-color: #4CAF50;
            color: white;
        }

        li a:hover:not(.active) {
            background-color: #555;
            color: white;
        }
    </style>
    <link rel="stylesheet" href="navbar.css" type="text/css"/>
</head>
<body>
<div id="addUserForm">
    <h2>Enter transaction data:</h2>
    <table>
        <td>
            <form:form method="POST"
                       action="${pageContext.request.contextPath}/adduserdb"
                       commandName="userFormModel">

                <form:errors path="login"/>
                <form:label path="login">Login:  <br></form:label>
                <br>
                <form:input path="login"/>
                <br>
                <form:errors path="password"/>
                <form:label path="password">Password:   <br></form:label>
                <br>
                <form:input path="password"/>
                <br>
                <input type="radio" name="role" value="USER" checked> User<br>
                <input type="radio" name="role" value="SUPERUSER"> Superuser<br>
                <input type="radio" name="role" value="ADMIN"> Admin
                <br>
                <input type="submit" value="Register!" id="submit" />
            </form:form>
        </td>
        <td><ul>
            <li><a href="admin">Admin page</a></li>

            <li><a href="superuser">Superuser page</a></li>

            <li><a href="newPerson">New person form</a></li>

            <li><a href="adduserdb">New user form</a></li>


        </ul></td>
    </table>
</div>
</body>
</html>
