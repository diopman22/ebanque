<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@include file="header.html" %>
	<title>Liste des comptes</title>
</head>
<body>
	<%@include file="menu.html" %>
        <div class="container">
            <h1 class="text text-info">Liste comptes</h1>
            <!--Table de listing des comptes-->
            <table class="table table-striped table-responsive" id="myTable">
               
                <s:if test="model.cptDAO.list.size">
                <thead>
                    <th>#</th>
                    <th>Solde</th>
                    <th>Decouvert</th>
                    <th>Debit maximal</th>
                    <th>Proprietaire<br>(Prenom(s) & nom)</th>
                </thead>
                       
                <% int i=0; %>
                <tbody>
                    <s:iterator value="model.cptDAO.list">
                    <tr>
                        <td><%=++i%></td>
                        <td><s:property value="solde"></s:property></td>
                        <td><s:property value="decouvert"></s:property></td>
                        <td><s:property value="debitMax"></s:property></td>
                        <td><s:property value="nomProp"></s:property> <s:property value="prenomProp"></s:property></td>
                        
                    </tr>
                    </s:iterator>
                </tbody>
                </s:if>
                
            </table>
        </div>
        
        <script type="text/javascript" src="resources/dist/js/dataTables/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="resources/dist/js/dataTables/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">
           $(document).ready(function(){
               $("#myTable").dataTable(); 
               
               $("div.alert").show("slow").delay(2000).hide("slow");
           }); 
        </script>
</body>
</html>