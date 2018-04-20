<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1>TEST SESIJE</h1></center>
    <% session.setAttribute("name", "pera");  %>
    <a href='http://localhost:8080/Kviz/testsesije'>Testiraj</a>
    </body>
</html>
