<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
	<title>Lista Prestamos</title>
</head>
<body>
	<jsp:include page="Menu.html"></jsp:include>
	<h1>Lista de Préstamos</h1>

<form method="get" action="ServletPrestamos">

	Buscar Cliente: <input type="text" name="txtBuscarCliente"/>
	
	<br><br>	
	
	<table border="1" width="900">
		<thead>
			<tr>
				<th>Nro. de Préstamo</th>
				<th style="width: 139px; ">Cliente</th>
				<th>Cuenta</th>
				<th>Monto</th>
				<th style="width: 139px; ">Saldo</th>
				<th>Acción 1</th>
	            <th>Acción 2</th>
			</tr>
		</thead>
			<tbody>
				<tr>
					<td>		</td>
					<td>		</td>
					<td>		</td>
					<td>		</td>
					<td>		</td>
					<td><input type="submit" name="btnModificar" value="Autorizar"/></td>
					<td><input type="submit" name="btnEliminar" value="Rechazar"/></td>
				</tr>	
			</tbody>
	</table>
		<div>
			<a class="btn btn-primary" href="Inicio.jsp">Volver</a>
		</div>
</form>

</body>
</html>