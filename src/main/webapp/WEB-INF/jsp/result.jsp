

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>New user created confirmation</title>
    <style>
        table, th, td {
            border: 2px solid black;
        }
    </style>
</head>
<body>

<h2>Submitted person information</h2>
<table style="">
    <tr>
        <th>Name</th>
        <td>${firstName}</td>
    </tr>
    <tr>
        <th>Age</th>
        <td>${lastName}</td>
    </tr>
    <tr>
        <th>ID</th>
        <td>${age}</td>
    </tr>
</table>
</body>
</html>