<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>Reportes</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="Style.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<jsp:include page="Menu.jsp"></jsp:include>
<h3>Reportes</h3>

<form action="ServletReportes" method="post">
	<table>
		<tr>
		<td style="width: 300px; ">
		Cantidad de clientes totales ingresados
		</td>
		<td align="center" colspan="2">
			<div>
				<a class="btn btn-primary" href="ServletReportes?reporte1=1">Generar</a>
			</div>
		</td>
		<%
		int cantidad=0;
		if(request.getAttribute("cantidad")!=null){ 
		cantidad =(int)request.getAttribute("cantidad");
		%>
		<td style="width: 300px; " align="center"><input type="text" readonly value="<%= cantidad%>"/></td>
		<%
		 }
		 %>
		</tr>	
	</table>
	<br><br>
	<table>
		<tr>
		<td style="width: 300px; ">Cantidad de ingresos totales entre:</td>
			<td align="center">
			Fecha inicial <br>
			<input type="date" name="txtFechaInicio" value="DD/MM/AAAA"/>
			</td>
			<td align="center">
			Fecha final <br>
			<input type="date" name="txtFechaFin" value="DD/MM/AAAA"/>
			</td>
		</tr>
		<tr>
		<td></td>
			<td align="center" colspan="2">
			<div>
				<a class="btn btn-primary" href="ServletReportes?reporte2=1">Generar</a>
			</div>
			</td>
		</tr>	
	</table>
	
</form>
	
	
</body>

</html>