<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista de Cuentas</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<jsp:include page="Navegacion.jsp"></jsp:include>
	<h1>Lista de Cuentas</h1>

<form method="get" action="ServletListaCuentas">
	 <table>
	 	<tr>
	 		<td>Filtrar: </td>
	 		<td><select name="filtros">
		<option value="" >Todos</option>
		<!-- ACA  SE DESARROLLARA SEGUN EL FULTRO QUE PIDA LA PROFESORA -->
		
	</select></td>
	 	</tr>
	 	<tr>
	 		<td align="right">Búsqueda de Cuenta: </td>
	 		<td style="height: 0px;"><input type="text" name="txtBusqueda"/></td>
	 	</tr>
	 </table>
	
	<br><br>	
	
	<table border="1" width="900">
		<thead>
			<tr>
				<th>Nro. de Cuenta</th>
				<th>CBU</th>
				<th>Tipo</th>
				<th>Fecha de Creación</th>
				<th>DNI del Cliente</th>
				<th>Saldo</th>
				<th>Estado</th>
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
					<td><input type="submit" name="btnModificar" value="Modificar"/></td>
					<td><input type="submit" name="btnModificar" value="Eliminar"/></td>	
				</tr>	
			</tbody>
		
	</table>
		<div>
			<a class="btn btn-primary" href="Inicio.jsp">Volver</a>
		</div>
	
</form>

</body>
</html>