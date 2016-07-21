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
<table>

    <td>This is ADMIN page accessible only by authenticated and authorized ADMINS</td>
<td><ul>
    <li><a href="admin">Admin page</a></li>

    <li><a href="superuser">Superuser page</a></li>

    <li><a href="newPerson">New person form</a></li>

    <li><a href="adduserdb">New user form</a></li>


</ul></td>

</table>



</body>
</html>
