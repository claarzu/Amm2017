<%-- 
    Document   : sidebar
    Created on : 14-apr-2017, 16.54.47
    Author     : claar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <meta charset="UTF-8">
        <meta name="author" content="Claudio Arzu">
        <meta name="description" content="AMM2017">
        <meta name="keywords" content="Amm2017">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/filter.js"></script>
    </head>
    <body>
        <aside class="sidebar">   
            <h1>Persone</h1>
            <ul class="sidebar_ul" id="usersList">                
                <li class="userData"><a href="Bacheca?user=${iscritto.id}" target="_blank">${iscritto.nome}</a></li>                              
            </ul>
            <br>
            <h1>Gruppi</h1>
            <ul class="sidebar_ul">
                <li class="img_gruppi"><a href="#gruppo1">Gruppo1</a></li>
                <li class="img_gruppi"><a href="#gruppo2">Gruppo2</a></li>
                <li class="img_gruppi"><a href="#gruppo3">Gruppo3</a></li>
            </ul>
        </aside> 
    </body>
</html>
