<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
	<title>Lista Clientes</title>
</head>
<body>
<jsp:include page="Navegacion.jsp"></jsp:include>
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
	 		<td align="right">Busqueda de Cliente</td>
	 		<td style="height: 0px;"><input type="text" name="txtBusqueda"/></td>
	 	</tr>
	 </table>
	
	<br><br>	
	
	<table border="1" width="900">
		<thead>
			<tr>
				<th>DNI</th>
				<th style="width: 139px; ">CUIL</th>
				<th>NOMBRE</th>
				<th>APELLIDO</th>
				<th style="width: 139px; ">CBU</th>
				<th>TIPO CUENTA</th>
				<th>SALDOS</th>
				<th>otra cosa</th>

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
					<td><input type="submit" name="btnModificar" value="MODIFICAR"/></td>
					<td><input type="submit" name="btnEliminar" value="ELIMINAR"/></td>
					
					
				
				</tr>
			
			</tbody>
		
	</table>
		<div>
			<a class="btn btn-primary" href="Inicio.jsp">Volver</a>
		</div>
	
</form>

</body>
</html>