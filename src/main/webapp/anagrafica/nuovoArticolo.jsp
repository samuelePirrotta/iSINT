<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import="it.sp.job.inv.beans.Record"%>
<%@ page import="it.sp.job.inv.beans.Unita"%>
<%@ page import="it.sp.job.inv.beans.Deposito"%>
<%@ page import="java.util.Vector"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>iSINT - Nuovo Articolo</title>
<!-- Bootstrap CSS CDN -->
<link rel="stylesheet" type="text/css"
	href="/bootstrap/css/bootstrap.css">
<!-- Font Awesome CSS -->
<link rel="stylesheet" type="text/css" href="/fontawesome/css/all.css">
<!-- Our Custom CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" type="text/css" href="/css/style-header.css">
<link rel="stylesheet" type="text/css" href="/css/style-mask.css">
<!-- Java Script File -->
<script type="text/javascript" src="/js/function.js"></script>
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
		<h1>Nuovo Articolo</h1>
	</div>
	<div id="content">
		<%
			
			Vector<Unita> unit;
			Vector<Deposito> dep;
			if (request.getAttribute("unita") == null || request.getAttribute("depositi") == null) {
				//out.write("Errore generico riprova piÃ¹ tardi");
				return;
			} else {
				unit = (Vector<Unita>) request.getAttribute("unita");
				dep = (Vector<Deposito>) request.getAttribute("depositi");
		%>	
		<div id="mask">
			<form name="datiArticolo" method="get" onkeypress="return (event.keyCode!=13)">
				<div class="row">
					<div class="col-md-6">
						<label>Codice*</label>
						<input type="text" id="codice" name="codice" maxlength="80" class="width-80" onkeyup="upper(codice)"/>
					</div>
					<div class="col-md-6">
						<label>Deposito</label>
						<select id="deposito" name="deposito">
							<% for (Deposito d: dep) { %>
									<option value="<%=d.getNome()%>"><%=d.getNome()%></option>
							<% } %>							
						</select>
					</div>
				</div>
				<div class="row" id="space"></div>
				<div class="row">
					<div class="col-md-12">
						<label>Descrizione*</label>
						<input type="text" id="descrizione" name="descrizione" maxlength="80" class="width-80" onkeyup="upper(descrizione)"/>			
					</div>
				</div>
				<div class="row" id="space"></div>
				<div class="row">
					<div class="col-md-4">
						<label>EAN</label>
						<input type="text" id="ean" name="ean" maxlength="13" class="width-80" onkeyup="" />
					</div>
				</div>
				<div class="row" id="space"></div>
				<div class="row">
					<div class="col-md-6">
						<label>Giacenza</label>
						<input type="text" id="giacenza" name="giacenza" class="width-20" class="width-80" placeholder="0.0"/>
					</div>
					<div class="col-md-6">
						<label>Unita' di Misura</label>
						<select id="unita" name="unita">
							<% for (Unita t: unit) { %>
									<option value="<%=t.getNome()%>"><%=t.getNome()%></option>
							<% } %>							
						</select>
					</div>
				</div>
				<div class="row" id="space"></div>		
				<div class="row">
					<div class="col-md-8"></div>
					<div class="col-md-2">
						<input type="button" class="btn width-60" onclick="location.href='/RichiediCercaArticolo'" value="Annulla" />
					</div>
					<div class="col-md-2">						
						<input type="submit" id="salva" onclick="valida()" class="btn width-60" value="Salva" />
					</div>
				</div>
			</form>
			<p> I campi contrassegnati da * sono obligatori </p>
		</div>
	<% } %>
	</div>
	<%@ include file="/includeFile/footer.txt" %>
	
	<% } %>
</body>
</html>