<%-- 
    Document   : profilo
    Created on : 14-apr-2017, 17.14.03
    Author     : claar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook - Profilo</title>
        <meta charset="UTF-8">
        <meta name="author" content="Claudio Arzu">
        <meta name="description" content="milestone 1, AMM2017">
        <meta name="keywords" content="HTML, Amm2017">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div class="contenitore">            
            <nav class="navbar">
                <ul class="nav_bar">
                    <li id="head"><a href="#NerdBook">NerdBook</a></li>
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
                <div class="box_profilo">
                    <div class="sign_in">
                        <img id="utente2" alt="immagine del profilo" src="${iscritto.urlImmProfilo}">
                    </div>
                    
                    <div class="form_box">
                        <form class="form_signin" action="Profilo" method="POST">
                            <c:if test="${invalidData == true}">
                                <label id="invalidData">Accesso non consentito</label>
                                <br>
                            </c:if>
                            <c:if test="${avviso == true}">
                                    <label id="avviso">Dati aggiornati.</label>
                                    Ricorda le nuove credenziali:
                                    Username: "${iscritto.username}" - Password: "${iscritto.psw}"
                                    <br>
                            </c:if> 
                            <br>
                            <label for="nome">Nome</label>                                
                                <input type="text" id="nome" name="nome" value="${iscritto.nome}" required>
                                <br>
                            <label for="cognome">Cognome</label>
                                <input type="text" id="cognome" name="cognome" value="${iscritto.cognome}" required>
                                <br>
                            <label for="url_img">Indirizzo immagine profilo</label>
                            <input type="url" id="url_img" name="url_img" value="${iscritto.urlImmProfilo}" placeholder="Inserisci url" required>
                                <br>
                            <label for="frase">Frase di Presentazione</label>
                                <textarea rows="7" cols="20" id="frase" name="frase" value="${iscritto.frase}" placeholder="Inserisci frase" required>${iscritto.frase}</textarea>
                                <br>
                            <label for="data">Data di Nascita</label>
                            <!--lo strumento di validazione mi da un warning, in quanto il tipo di input "date" non è supportato da tutti i browser -->
                                <input type="date" id="data" name="data" value="${iscritto.nascita}" required> 
                                <br>
                            <label for="username">Username</label>                                
                                <input type="text" id="username" name="username" value="${iscritto.username}" required>
                                <br>
                            <label for="psw">Password</label>
                                <input type="password" id="psw" name="psw" value="oscurato" placeholder="Inserisci password" required>
                                <br>
                            <button id="conferma" type="submit" name="conferma">Aggiorna</button>
                            <button id="cancella" type="reset" name="cancella">Cancella Campi</button>                   
                        </form>
                        <c:if test="${c_account==true}">
                            <form class="form_signin" action="Profilo" method="POST">
                                <button id="conferma" type="submit" name="elimina">Cancella Account</button>
                            </form>
                        </c:if>                                   

                    </div>
                </div>
            </div>           
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>

