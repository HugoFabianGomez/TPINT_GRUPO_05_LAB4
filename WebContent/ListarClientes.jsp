<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Cliente" %>
<%@ page import="presentacion.controller.ServletClientes" %>
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
	<%
	ArrayList<Cliente> lista_cliente;
	lista_cliente = (ArrayList<Cliente>) ServletClientes.obtenerClientes();
	%>
	<jsp:include page="Menu.html"></jsp:include>
	<h1>Lista de Clientes</h1>

<form method="post" action="ListarClientes">
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
	
	<table border="1" width="900" id="tablacliente">
		<thead>
			<tr>
				<th>DNI</th>
				<th style="width: 139px; ">CUIL</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th style="width: 139px; ">Email</th>
				<th>Telefono</th>
				<th>Fecha Nac</th>
				<th>Estado</th>

			</tr>
		</thead>
			<tbody>
				<%  
					if(lista_cliente!=null)
					for(Cliente cl : lista_cliente) 
				{
				%>
				<tr>
					<td><%= cl.getDni() %></td>
					<td><%= cl.getCuil() %>		</td>
					<td><%= cl.getNombre() %>		</td>
					<td><%= cl.getApellido() %>		</td>
					<td><%= cl.getEmail() %>		</td>
					<td><%= cl.getTelefono() %>		</td>
					<td><%= cl.getFechaNacimiento() %>		</td>
					<td><%= cl.getEstado() %>		</td>
					<td><a class="btn btn-primary" href="/TPINT_GRUPO_05_LAB4/ModificarCliente.jsp?dni=<%=cl.getDni()%>">Modificar</a></td>
					<td><input type="submit" name="btnEliminar" value="Eliminar"/></td>
					
				</tr>
				<%  } %>
			</tbody>
	</table>
		<div>
			<a class="btn btn-primary" href="Inicio.jsp">Volver</a>
		</div>
	
</form>

</body>
</html>