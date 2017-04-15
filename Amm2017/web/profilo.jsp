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
        <title>Pagina profilo della Milestone 2</title>
        <meta charset="UTF-8">
        <meta name="author" content="Claudio Arzu">
        <meta name="description" content="milestone 1, AMM2017">
        <meta name="keywords" content="HTML, Amm2017">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div class="contenitore">            
            <jsp:include page="navbar.jsp" />            
            <div id="profile">
                <jsp:include page="sidebar.jsp" />
                <br>
                <div class="box_profilo">
                    <div class="sign_in">
                        <img id="utente2" alt="immagine del profilo" src="Immagini/utenti.png">
                    </div>
                    <div class="form_box">
                        <form class="form_signin" action="sighin.html" method="post">

                            <label for="nome">${iscritto.getNome()}</label>                                
                                <input type="text" id="nome" name="name" value="mario nome" required>
                                <br>
                            <label for="cognome">Cognome</label>
                                <input type="text" id="cognome" name="cognome" value="rossi" required>
                                <br>
                            <label for="url_img">Indirizzo immagine profilo</label>
                                <input type="url" id="url_img" name="url_img" placeholder="Inserisci url" required>
                                <br>
                            <label for="frase">Frase di Presentazione</label>
                                <textarea rows="7" cols="20" id="frase" name="frase" placeholder="Inserisci frase" required></textarea>
                                <br>
                            <label for="data">Data di Nascita</label>
                            <!--lo strumento di validazione mi da un warning, in quanto il tipo di input "date" non è supportato da tutti i browser -->
                                <input type="date" id="data" name="01/01/1990" required> 
                                <br>
                            <label for="psw">Password</label>
                                <input type="password" id="psw" name="psw" value="oscurato" placeholder="Inserisci password" required>
                                <br>
                            <label for="c_psw">Conferma Password</label>
                            <input type="password" id="c_psw" name="c_psw" value="oscurato" placeholder="Conferma password" required>
                                <br>
                            <button id="conferma" type="submit" name="conferma">Aggiorna</button>
                            <button id="cancella" type="reset" name="cancella">Cancella Campi</button> 
                        </form>
                    </div>
                </div>
            </div>           
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>

