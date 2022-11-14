<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Reportes</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	
	<jsp:include page="Menu.html"></jsp:include>
<h3>Reportes</h3>

<form action="servletSeguro" method="get">
	<table>
		<tr>
		<td style="width: 300px; ">Cantidad de clientes ingresados entre:</td>
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
			<td align="center" colspan="2"><input type="submit" name="btnGenerar" value="Generar"/></td>
		</tr>	
	</table>
	<br><br>
	<table>
		<tr>
		<td style="width: 300px; ">Cantidad de préstamos pedidos entre:</td>
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
			<td align="center" colspan="2"><input type="submit" name="btnGenerar" value="Generar"/></td>
		</tr>	
	</table>
	
</form>
	
</body>
</html>