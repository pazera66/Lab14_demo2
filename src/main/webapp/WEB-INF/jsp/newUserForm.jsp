<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>

    <style>
        table, th, td {
            border: 5px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<div id="addUserForm">
    <h2>Enter transaction data:</h2>
    <table>
        <td>
            <form:form method="POST"
                       action="${pageContext.request.contextPath}/addUser"
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
    </table>
</div>
</body>
</html>
