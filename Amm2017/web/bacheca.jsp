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
        <meta name="description" content="AMM2017">
        <meta name="keywords" content="Amm2017">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/filter.js"></script>
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
                <aside class="sidebar">                    
                    <div id="searchIscritto">                        
                        <h1 id="searchError">non trovato</h1>                       
                        <input id="searchField" type="text" placeholder="cerca il tuo amico" value="">
                        <button id="searchFriend">Cerca!</button>
                    </div>
                    <br>        
                    <h1>Persone</h1>
                    <ul class="sidebar_ul" id="usersList">
                    <c:forEach var="iscritto" items="${lista}">    
                        <li class="link"><a href="Bacheca?user=${iscritto.id}" target="_blank">${iscritto.nome}</a></li>
                        <br>
                    </c:forEach>
                    <c:forEach var="iscritto" items="${usersList}">    
                        <li class="link"><a href="Bacheca?user=${iscritto.id}" target="_blank">${iscritto.nome}</a></li>
                        <br>
                    </c:forEach>
                     
                    </ul>
                    <br>
                    <h1>Gruppi</h1>
                    <ul class="sidebar_ul">
                        <li class="img_gruppi"><a href="#gruppo1">Gruppo1</a></li>
                        <li class="img_gruppi"><a href="#gruppo2">Gruppo2</a></li>
                        <li class="img_gruppi"><a href="#gruppo3">Gruppo3</a></li>
                    </ul>
                </aside> 
                <br>
                <div id="usersList">
                <c:forEach var="iscritto" items="${usersList}">
                    <div class="user">                        
                        <div class="userData">
                            <h2>${iscritto.nome}</h2>
                            <a href="Profilo?user=${iscritto.id}">Vai al profilo</a>
                            <br>
                        </div>                        
                    </div>
                </c:forEach>
                </div>
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
