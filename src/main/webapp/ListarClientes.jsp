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

<form metod="get" action="ServletListaclientes">
	 <td>	Filtros de Lista de Clientes</td> 
	<select name="">
		<option value="" >Todos</option>
		<!-- ACA  SE DESARROLLARA SEGUN EL FULTRO QUE PIDA LA PROFESORA -->
		
	</select>
	<td></td>
	<td style="width: 380px;" align="right">Busqueda de Cliente</td>
	<td style="height: 0px; "><input type="text" name="txtBusqueda"/></td>
	
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
				<th>Acción</th>
	            <th>Acción</th>
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
					<td>		</td>
					
				
				</tr>
			
			</tbody>
		
	</table>
		<div>
			<a class="btn btn-primary" href="Inicio.jsp">Volver</a>
		</div>
	
</form>

</body>
</html>