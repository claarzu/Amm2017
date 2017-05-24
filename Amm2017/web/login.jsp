<%-- 
    Document   : login
    Created on : 14-apr-2017, 15.59.00
    Author     : claar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <c:set var="title" value="Login" scope="request"/>
        <div class="contenitore">            
            <nav class="navbar">
                <ul class="nav_bar">
                    <li id="head"><a href="descrizione.jsp">NerdBook</a></li>
                    <li><a href="descrizione.jsp">Descrizione</a></li>
                    <li><a href="Profilo">Profilo</a></li>
                    <li><a href="Bacheca">Bacheca</a></li>
                </ul>
            </nav>
            <br>
            <div class="log_in">
                <img id="utente" alt="profile" src="Immagini/utenti2.png">
                <h2 id="titolo_form">Login a Nerdbook</h2>
            </div>
            <div class="form_box_login">
                <form action="Login" method="post">                    
                    <br>
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username" placeholder="Inserisci Username" required/>
                        <br>
                    <label for="psw">Password</label>
                        <input type="text" name="password" id="psw" placeholder="Inserisci Password" required/>
                        <br>
                        <button class="conferma" name="Submit" type="submit">Login</button>
                        <button class="cancella" type="reset">Cancella Campi</button>
                    <label id="invalidData" for="errore">
                        <c:if test="${!empty errore}">
                            <c:out value="${errore}"/>
                        </c:if>
                    </label>
                </form>
            </div>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
