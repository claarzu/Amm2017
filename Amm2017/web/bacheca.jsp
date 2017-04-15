<%-- 
    Document   : bacheca
    Created on : 14-apr-2017, 17.09.20
    Author     : claar
--%>

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
            <jsp:include page="navbar.jsp" />            
            <div id="profile">
                <jsp:include page="sidebar.jsp" />
                <br>
                <div class="stati">
                    <div class="stato_utente">
                        <h2 class="ut">Utente</h2>
                        <div>
                            <span class="stato">
                                Ciao a tutti!!! Questa &egrave; la mia bacheca!!!
                            </span>
                        </div>
                    </div>
                    <div class="stato_utente">                        
                        <h2 class="pt">Pluto</h2>
                        <div>
                            <p><i>Stato di Pluto:</i></p>
                            <span class="stato">
                                Kaffèèèè1!1!1!1!
                            </span>
                        </div>
                    </div>
                    <br>
                    <div class="stato_utente">                        
                        <h2 class="tp">Topolino</h2>
                        <div>
                            <p><i>Stato di Topolino:</i></p>
                            <span class="stato">
                                Che bella scheda...
                                <br>
                                <img class="profile_img" title="stato" alt="foto stato topolino" src="Immagini/schedamadre.jpg" width="276" height="77">
                            </span>
                        </div>
                    </div>
                    <br>
                    <div class="stato_utente">
                        
                        <h2 class="pp">Paperino</h2>
                        <div>
                            <p><i>Stato di Paperino:</i></p>
                            <span class="stato">
                                il sito di <a href="https://unica.it">unica</a>
                            </span>
                        </div>
                    </div>
                </div>
            </div>           
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
