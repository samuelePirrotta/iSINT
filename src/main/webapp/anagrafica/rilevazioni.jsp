<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.sp.job.inv.beans.Record"%>
<%@ page import="java.util.Vector"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>iSINT - Lista Rilevazioni</title>
<!-- Bootstrap CSS CDN -->
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<!-- Font Awesome CSS -->
<link rel="stylesheet" type="text/css" href="/fontawesome/css/all.css">
<!-- Our Custom CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" type="text/css" href="/css/style-header.css">
<link rel="stylesheet" type="text/css" href="/css/style-mask.css">
<link rel="stylesheet" type="text/css" href="/css/home.css">
<script type="text/javascript" src="/js/function.js"></script>

<!-- Barcode Scanner -->
<script src="https://unpkg.com/scandit-sdk"></script>

<%@ include file="/includeFile/favIcon.txt" %>
</head>
<body>
	<% 	
		boolean autenticato = (boolean) session.getAttribute("autenticato");
		if(autenticato) {
	%>
	
	<%@ include file="/includeFile/navBar.txt" %>
	
	<div id="header">
		<p>
		<h1>Lista Rilevazioni</h1>	
	</div>
	
	<div id=content>
		<div id="mask">
			<form name="datiArticolo" action="/CercaRilevazione" method="post" >
				<div class="row">
					<div class="col-md-3">
						<label>EAN</label>
						<input type="text" name="ean" maxlength="13" class="width-80">
					</div>
					<div class="col-md-1">
						<button type="button" onclick="startScan()"><i class="fas fa-barcode fa-2x" area-hidden="true"></i></button>
					</div>
					<div class="col-md-5">
						<label>Descrizione</label>
						<input type="text" name="descrizione" maxlength="80" class="width-60" onkeyup="upper(descrizione)">
					</div>
					<div class="col-md-3">
						<label>Codice</label>
						<input type="text" name="codice" maxlength="80" class="width-60" onkeyup="upper(codice)">
					</div>
				</div>
				<div class="row" id="space"></div>
				<div class="row" id="space"></div>
				<div class="row">
					<div class="col-md-10"></div>
					<div class="col-md-2">
						<input type="submit" value="Cerca" class="btn width-60"/>
					</div>				
				</div>			
			</form>
			<div id="barcode-picker" style="max-width: 1280px; max-height: 80%;"></div>
		</div>
		<div class="table">
			<%
				Vector<Record> articoli;
				if (request.getAttribute("articoli") == null) {
					//out.write("Errore generico riprova più tardi");
					return;
				} else {
					articoli = (Vector<Record>) request.getAttribute("articoli");
			%>
				<table class="table">	
					<tr id="intestazione">
						<td>EAN</td>
						<td>Codice Articolo</td>
						<td>Descrizione</td>
						<td>Giacenza</td>
						<td>Deposito</td>
					</tr>
					<%  
						for (Record a : articoli) {  
					%>
						<tr id="dati">
							<td><%=a.getEan()%></td>
							<td><%=a.getArticolo()%></td>
							<td><%=a.getDescrizione()%></td>
							<td><%=a.getGiacenza()%></td>
							<td><%=a.getDeposito()%></td>
						</tr>
					<% } %>
				</table>
			<% } %>			
		</div>		
	</div>
	<%@ include file="/includeFile/footer.txt" %>
	<% } %>	
</body>
</html>