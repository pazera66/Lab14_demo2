<!DOCTYPE html>
<html>
<head>
    <title>$Title$</title>
    <style>
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


   <ul>
       <li><a href="localhost:8096/admin">Admin page</a></li>

       <li><a href="localhost:8096/superuser">Superuser page</a></li>

       <li><a href="localhost:8096/newPerson">New person form</a></li>

       <li><a href="localhost:8096/adduserdb">New user form</a></li>


   </ul>



</body>
</html>
