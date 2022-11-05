<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista de Clientes</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="Menu.html"></jsp:include>
	<h1>Lista de Clientes</h1>

<form method="get" action="ServletListaclientes">
	 <table>
	 	<tr>
	 		<td>Filtros de Lista de Clientes</td>
	 		<td><select name="">
		<option value="" >Todos</option>
		<!-- ACA  SE DESARROLLARA SEGUN EL FULTRO QUE PIDA LA PROFESORA -->
	</select></td>
	 	</tr>
	 	<tr>
	 		<td align="right">Búsqueda de Cliente</td>
	 		<td style="height: 0px;"><input type="text" name="txtBusqueda"/></td>
	 	</tr>
	 </table>
	
	<br><br>	
	
	<table border="1" width="900">
		<thead>
			<tr>
				<th>DNI</th>
				<th style="width: 139px; ">CUIL</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th style="width: 139px; ">CBU</th>
				<th>Tipo de Cuenta</th>
				<th>Saldo</th>
				<th>Observaciones</th>

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
					<td>		</td>
					<td><input type="submit" name="btnModificar" value="Modificar"/></td>
					<td><input type="submit" name="btnEliminar" value="Eliminar"/></td>
					
					
				
				</tr>
			
			</tbody>
		
	</table>
		<div>
			<a class="btn btn-primary" href="Inicio.jsp">Volver</a>
		</div>
	
</form>

</body>
</html>