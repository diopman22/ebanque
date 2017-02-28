<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Credit Compte</title>
    </head>
    <body>
        <%@include file="menu.html" %>
        <h1>Crediter Compte</h1>
        <s:form method ="post" action="crediterCompte">
                <s:textfield name="cpt.idCompte" type="number" label="Identifiant compte"></s:textfield>
                <s:textfield name="montant" step="0.01" type="number" min="0" label="Montant"></s:textfield>
                
                <s:submit value="Envoyer" />
        </s:form>
    </body>
</html>
