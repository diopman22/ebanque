<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Edition Compte</title>
    </head>
    <body>
        <%@include file="menu.html" %>
        <div class="container">
            <h2>Editer compte</h2>
            <s:form method ="post" action="createCompte">
		        
                <s:textfield name="cpt.nomProp" id="nom" readonly="yes" label="Nom">
                </s:textfield>

                <s:textfield name="cpt.nomProp" id="prenom" readonly="yes" label="Prenom">
                </s:textfield>

                <s:textfield name="cpt.adresseProp" id="adresse"  readonly="yes" label="Adresse">
                </s:textfield>

                <s:textfield name="cpt.solde" id="solde" step="0.001" label="Solde">
                </s:textfield>

                <s:textfield name="cpt.decouvert" id="decouvert" step="0.001" label="Decouvert">
                </s:textfield>	

                <s:textfield name="cpt.debitMax" id="debitMax" step="0.001" label="Debit maximal">
                </s:textfield>

                <s:submit value = "Envoyer"></s:submit>
		
            </s:form>
        </div>
    </body>
</html>