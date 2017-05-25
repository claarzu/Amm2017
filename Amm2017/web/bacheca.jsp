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
        <title>NerdBook - Bacheca</title>
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
                <c:choose>
                <c:when test="${empty newpost}">
                <div id="nuovo_stato">
                    <form action="NewPost" method="POST">
                        <div id="postType">                            
                            <c:if test="${invalidData == true}">
                                <h2 class="invalidData">Accesso non consentito</h2>
                            </c:if>                            
                            <br>
                                <div>
                                <label for="textType">Post di Testo</label>
                                <input type="radio" name="postType" value="textType" id="textType">
                                </div>
                                <div>
                                    <label for="imgType">Post con Foto</label>
                                    <input type="radio" name="postType" value="imgType" id="imgType">
                                </div>
                        </div>
                        <div id="postContent">
                            <div>
                                <label for="textPost">Testo</label>
                                <textarea name="textPost" id="textPost"></textarea>
                            </div>
                            <div>
                                <label for="imgPost">File d'immagine</label>
                                <input type="file" name="imgPost" id="imgPost">
                            </div>
                        </div>
                        <button type="submit" name="Submit" value="needConfirm">Inserisci Post</button>                       
                    </form>
                    <br>
                </div>
                </c:when>
                <c:otherwise>
                    <div id="nuovo_stato">
                        <form action="NewPost" method="post">
                            <c:if test="${typePost == 'textType'}">
                                <label>${content}</label>
                                <input type="text" hidden name="textPost" value="${content}">
                            </c:if>
                            <c:if test="${typePost == 'imgType'}">
                                <label><img src="${content}" alt="immagine"></label>
                            </c:if>                            
                            <input type="text" hidden name="postType" value="${typePost}">
                            <button type="submit" name="Submit" value="Confirmed">Conferma</button>
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>                
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
