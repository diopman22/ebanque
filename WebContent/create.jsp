<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="menu.html" %>
        <div class="container">
            <h2>Creation compte</h2>
            <s:form method ="post" action="createCompte">
		        
                <s:textfield name="cpt.nomProp" id="nom" label="Nom">
                </s:textfield>

                <s:textfield name="cpt.nomProp" id="prenom" label="Prenom">
                </s:textfield>

                <s:textfield name="cpt.adresseProp" id="adresse" label="Adresse">
                </s:textfield>

                <s:textfield name="cpt.solde" id="solde" type="number" step="0.001" label="Solde">
                </s:textfield>

                <s:textfield name="cpt.decouvert" id="decouvert" type="number" step="0.001" label="Decouvert">
                </s:textfield>	

                <s:textfield name="cpt.debitMax" id="debitMax" type="number" step="0.001" label="Debit maximal">
                </s:textfield>

                <s:submit value = "Envoyer"></s:submit>
		
            </s:form>
        </div>
</body>
</html>