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
        />
        <form:label path="lastName">Last name:   <br></form:label>
        <form:errors path="lastName"
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
    </table>
</div>
</body>
</html>
