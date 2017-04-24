<%-- 
    Document   : bacheca
    Created on : 14-apr-2017, 17.09.20
    Author     : claar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pagina bacheca della Milestone 2</title>
        <meta charset="UTF-8">
        <meta name="author" content="Claudio Arzu">
        <meta name="description" content="milestone 1, AMM2017">
        <meta name="keywords" content="HTML, Amm2017">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div class="contenitore">
            <c:set var="page" value="bacheca" scope="request"/>
            <nav class="navbar">
                <ul class="nav_bar">
                    <li id="head"><a href="descrizione.jsp">NerdBook</a></li>
                    <li><a href="descrizione.jsp">Descrizione</a></li>
                    <li><a href="login.jsp">Login</a></li>
                </ul>
                <ul id="nav_user">
                    <li><h3>${iscritto.username}</h3></li>
                    <li><a href="#logout">Logout</a></li>
                </ul>
            </nav>           
            <div id="profile">
                <jsp:include page="sidebar.jsp" />
                <br>
                <div class="stati">
                    <c:if test="${!empty negato}">
                            <c:out value="${negato}"/>
                        </c:if>
                    <div class="stato_utente" id="posts">                            
                        <h2 class="ut">${iscritto.username}</h2>
                        <div>
                            
                            <p><i>Stato:</i></p>
                            <c:forEach var="post" items="${posts}">
                            <span class="stato">
                                <c:if test="${post.postType == 'TEXT'}">
                                    <c:out value="${posts}"/>
                                </c:if>
                                <c:if test="${post.postType == 'IMAGE'}">
                                    <img alt="foto post" src="${post.content}">                                        
                                </c:if>
                            </span>
                            </c:forEach>
                        </div>                            
                    </div>           
                </div>
            </div>           
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
