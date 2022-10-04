<%@page import="web.CreditModel"%>
<%@page 
	CreditModel model = (CreditModel)request.getAttribute("creditModel");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<div class="contaner">
		<div class="panel panel-primary">
			<div class="panel-header">Simulation credit</div>
		</div>
	</div>

	<div>
		<form action="calculerMensualite.do" method="post">
			<table>
				<tr>
					<td>Montant :</td>
					<td><input type="text" name="montant" value="<%=model.getMontant()%>"></td>
					<td>FCFA</td>
				</tr>
				<tr>
					<td>Taux :</td>
					<td><input type="text" name="taux" value="<%=model.getTaux()%>"></td>
					<td>%</td>
				</tr>
				<tr>
					<td>Duree :</td>
					<td><input type="text" name="duree" value="<%=model.getDuree()%>"></td>
					<td>Mois</td>
				</tr>
			</table>
			<button type="submit">Calculer</button>
		</form>
	</div>
	<div>
		Mensualite : <%=model.getMensualite()%>
	</div>
</body>
</html>