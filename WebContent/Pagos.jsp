<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
	<title>Lista Pagos</title>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<h1>LISTA DE PAGOS</h1>

<form method="get" action="ServletPagos">

	CLIENTE: <label id="lblCliente"></label>
	
	<br><br>	
	
	<table border="1" width="900">
		<thead>
			<tr>
				<th>NRO CUOTA</th>
				<th>CUENTA</th>
				<th>MONTO</th>
				<th style="width: 139px; ">SALDO</th>
				<th>ACCION</th>
	            <th>ACCION</th>
			</tr>
		</thead>
			<tbody>
				<tr>
					<td>		</td>
					<td>		</td>
					<td>		</td>
					<td>		</td>
					<td>		</td>
					<td>		</td>
					<td>		</td>
				</tr>	
			</tbody>
	</table>
		<div>
			<a class="btn btn-primary" href="Inicio.jsp">VOLVER</a>
		</div>
</form>

</body>
</html>