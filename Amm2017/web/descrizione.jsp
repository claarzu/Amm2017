<%-- 
    Document   : descrizione
    Created on : 14-apr-2017, 17.19.31
    Author     : claar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook</title>
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
                <aside class="sidebar">
                    <h2>Sezioni Pagina</h2>
                    <ul class="sidebar_ul">
                        <li class="elenco"><a href="#primo">Nerdbook</a></li>
                        <li class="elenco"><a href="#secondo">Abbonamenti</a></li>
                        <li class="elenco"><a href="#terzo">Pagamento</a></li>
                    </ul>
                                      
                </aside> 
                <br>
                <article class="principale">
                    <a id="primo"><h2>Social NerdBook</h2></a>
                    <p>NerdBook &egrave; il primo social dedicato al mondo nerd.</p>
                    <p>Il social non &egrave; completamente gratuito, infatti si deve pagare per ottenere alcune funzionalit&agrave;.</p>
                    <section class="descrizione">
                        <a id="secondo"><h3>Abbonamenti</h3></a>
                        <p>Ci sono diversi tipi di abbonamento, che permettono di far avere più visibilit&agrave; ai propri contenuti.</p>
                    </section>
                    <section class="descrizione">
                        <a id="terzo"><h4>Modalit&agrave; di pagamento</h4></a>
                        <p>Si pu&ograve; pagare con carta di credito, bonifico, paypal oppure con addebito su conto corrente.</p>
                    </section>
                </article>
            </div>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>