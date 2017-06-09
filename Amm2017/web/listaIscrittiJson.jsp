<%-- 
    Document   : listaIscrittiJson
    Created on : 6-giu-2017, 16.27.41
    Author     : claar
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="iscritto" items="${usersList}">
        <json:object>
            <json:property name="nome" value="${iscritto.nome}"/>
            <json:property name="cognome" value="${iscritto.conome}"/>
            <json:property name="id" value="${iscritto.id}"/>
            <json:property name="urlImmProfilo" value="${iscritto.urlImmProfilo}"/>
            <json:property name="frase" value="${iscritto.frase}"/>
            <json:property name="nascita" value="${iscritto.nascita}"/>
            <json:property name="username" value="${iscritto.username}"/>
            <json:property name="psw" value="${iscritto.password}"/>            
        </json:object>
    </c:forEach>
</json:array>