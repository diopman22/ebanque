<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Virement Compte</title>
    </head>
    <body>
        <%@include file="menu.html" %>
        <h1>Virement Compte</h1>
        <s:form method ="post" action="virementCompte">
            <s:textfield name="cpt.idCompte" type="number" label="Compte source"></s:textfield>
            <s:textfield name="cptDest.idCompte" type="number" label="compte destinaire"></s:textfield>
            <s:textfield name="montant" step="0.01" type="number" label="Montant"></s:textfield>
                
                <s:submit value="Envoyer" />
        </s:form>
    </body>
</html>
