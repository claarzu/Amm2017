<%-- 
    Document   : navbar
    Created on : 14-apr-2017, 16.48.56
    Author     : claar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <meta name="author" content="Claudio Arzu">
        <meta name="description" content="milestone 1, AMM2017">
        <meta name="keywords" content="HTML, Amm2017">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <nav class="navbar">
                <ul class="nav_bar">
                    <li id="head"><a href="#NerdBook">NerdBook</a></li>
                    <li><a href="descrizione.jsp">Descrizione</a></li>
                    <li><a href="login.jsp">Login</a></li>
                </ul>
                <ul id="nav_user">
                    <li><h3>Nome Utente</h3></li>
                    <li><a href="#logout">Logout</a></li>
                </ul>
        </nav>
    </body>
</html>
