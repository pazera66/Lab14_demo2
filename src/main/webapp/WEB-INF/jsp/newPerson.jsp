<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <%--<link href="/resources/css/main.css" rel="stylesheet">--%>
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
</head>
<body>
<div id="addPersonForm">
    <h2>Enter transaction data:</h2>
    <table>
        <td>
    <form:form method="POST"
               action="/addPerson"
    commandName="person">


        <form:label path="firstName">First name:  <br></form:label>
        <form:errors path="firstName"/>
        <br>
        <form:input path="firstName"/>
        <br>
        <form:label path="lastName">Last name:   <br></form:label>
        <form:errors path="lastName"/>
        <br>
        <form:input path="lastName"/>
        <br>

        <form:label path="age">Age:  <br></form:label>
        <form:errors path="age"/>
        <br>
        <form:input path="age"/>
        <br>
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
