<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
	<title>Lista Cuentas</title>
</head>
<body>
<jsp:include page="Navegacion.jsp"></jsp:include>
	<h1>Lista de Cuentas</h1>

<form method="get" action="ServletListaCuentas">
	 <table>
	 	<tr>
	 		<td>Filtros de Lista de Cuentas</td>
	 		<td><select name="filtros">
		<option value="" >Todos</option>
		<!-- ACA  SE DESARROLLARA SEGUN EL FULTRO QUE PIDA LA PROFESORA -->
		
	</select></td>
	 	</tr>
	 	<tr>
	 		<td align="right">Busqueda de Cuenta</td>
	 		<td style="height: 0px;"><input type="text" name="txtBusqueda"/></td>
	 	</tr>
	 </table>
	
	<br><br>	
	
	<table border="1" width="900">
		<thead>
			<tr>
				<th>NUMERO DE CUENTA</th>
				<th>CBU</th>
				<th>TIPO DE CUENTA</th>
				<th>FECHA DE CREACION</th>
				<th>DNI DEL CLIENTE</th>
				<th>SALDO</th>
				<th>ESTADO</th>

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
					<td><input type="submit" name="btnModificar" value="MODIFICAR"/></td>
					<td><input type="submit" name="btnModificar" value="ELIMINAR"/></td>	
				</tr>	
			</tbody>
		
	</table>
		<div>
			<a class="btn btn-primary" href="Inicio.jsp">Volver</a>
		</div>
	
</form>

</body>
</html>