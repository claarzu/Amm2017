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
        <c:set var="page" value="Bacheca" scope="request"/>
        <div class="contenitore">
            
            <nav class="navbar">
                <ul class="nav_bar">
                    <li id="head"><a href="descrizione.jsp">NerdBook</a></li>
                    <li><a href="descrizione.jsp">Descrizione</a></li>
                    <li><a href="login.jsp">Login</a></li>
                </ul>
                <ul id="nav_user">
                    <li><h3>${iscritto.username}</h3></li>
                    <c:if test="${empty param.user}">
                        <li><a href="Login?logout=1">Logout</a></li>
                    </c:if>
                </ul>
            </nav>           
            <div id="profile">
                <jsp:include page="sidebar.jsp" />
                <br>
                <div id="nuovo_stato">
                    <form action="Bacheca" method="POST">
                        <div id="postType">                            
                            <c:if test="${invalidData == true}">
                                <h2 class="invalidData">Accesso non consentito</h2>
                            </c:if>                            
                            <br>
                            <div>
                            <label for="textType">Post di Testo</label>
                            <input type="radio" name="textType" value="textType" id="textType">
                            </div>
                            <div>
                                <label for="imgType">Post con Foto</label>
                                <input type="radio" name="imgType" value="imgType" id="imgType">
                            </div>
                        </div>
                        <div id="postContent">
                            <div>
                                <label for="textPost">Testo</label>
                                <textarea name="textPost" id="textPost" value="${stato.content}"></textarea>
                            </div>
                            <div>
                                <label for="imgPost">File d'immagine</label>
                                <input type="file" name="imgPost" id="imgPost"
                                       value="${stato.content}">
                            </div>
                        </div>
                        <button type="submit" name="Submit">Inserisci Post</button>
                        <c:if test="${bottone == true}">
                            <button type="submit" name="Submit2">Conferma</button>                                   
                            <br>
                        </c:if>
                        <c:if test="${avviso == true}">
                            <label id="avviso">Hai aggiunto un post sulla tua bacheca.</label>
                                    Post Inserito da: "${iscritto.nome}" - nella bacheca di: "${iscritto.nome}"                                    
                            <br>
                        </c:if> 
                        <c:if test="${avviso2 == true}">
                            <label id="avviso2">Hai scritto sulla bacheca di: [${iscritto.nome}]</label>
                            <br>
                        </c:if> 
                    </form>
                    <br>
                </div>
                
                <div class="stati">                   
                    <div class="stato_utente" id="stati"> 
                                                    
                        <h2 class="ut">${iscritto.nome}</h2>
                        <c:forEach var="stato" items="${listaStati}">
                        <div id="stato">                            
                            <p><i>Stato:</i></p>                           
                            <span class="stato">                               
                                <c:if test="${stato.postType == 'TEXT'}">
                                    ${stato.content}
                                </c:if>
                                <c:if test="${stato.postType == 'IMAGE'}">
                                    <img class="profile_img" title="stato" alt="foto post" src="${stato.content}" width="276" height="77">
                                </c:if>
                            </span>                            
                        </div>
                        </c:forEach>                            
                    </div>           
                </div>
            </div>           
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
