<%@page import="negocio.ClienteNegocio"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Cliente" %>
<%@ page import="negocio.ClienteNegocio" %>
<%@ page import="negocioImpl.ClienteNegocioImpl" %>
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
			if(session.getAttribute("userid")==null || session.getAttribute("permiso")=="NoAdmin")
			{
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			}
		%>
	<%
	ClienteNegocio cliNegocio = new ClienteNegocioImpl();
	ArrayList<Cliente> lista_cliente;
	
	
	String DniaBuscar = request.getParameter("buscarDni"); 
	if(DniaBuscar != null && DniaBuscar !=""){
		lista_cliente = cliNegocio.obtenerTodos(Integer.parseInt(DniaBuscar));
	}else{
		lista_cliente = cliNegocio.obtenerTodos();

	}
	%>
	<jsp:include page="Menu.html"></jsp:include>
	<h1>Lista de Clientes</h1>
	
	<form action="ListarClientes.jsp" method="get">
        Buscar por Dni
        <input type="number" name="buscarDni" value="<%=DniaBuscar%>" >
        <button  class="btn btn-primary" type="submit">Buscar</button>
    </form>


	 <table>

	 	
	 </table>
	
	<br><br>	
	
	<table border="1" width="900" id="tablacliente">
		<thead>
			<tr>
				<th style="width: 500px; ">...DNI</th>
				<th></th>
				<th style="width: 139px; ">CUIL</th>
				<th></th>
				<th style="width: 800px; ">Nombre</th>
				<th></th>
				<th style="width: 800px; ">Apellido</th>
				<th></th>
				<th style="width: 1000px; ">Email</th>
				<th></th>
				<th style="width: 1000px; ">Telefono</th>
				<th></th>
				<th style="width: 2000px; ">Fecha_Nacio</th>
				<th></th>
				<th style="width: 139px; ">Estado</th>
			</tr>
		</thead>
			<tbody>
				<%  
					if(lista_cliente!=null)
					for(Cliente cl : lista_cliente) 
				{%>
				<tr>
					<td><%= cl.getDni() %></td>
					<th></th>
					<td><%= cl.getCuil() %>		</td>
					<th></th>
					<td><%= cl.getNombre() %>		</td>
					<th></th>
					<td><%= cl.getApellido() %>		</td>
					<th></th>
					<td><%= cl.getEmail() %>		</td>
					<th></th>
					<td><%= cl.getTelefono() %>		</td>
					<th></th>
					<td ><%= cl.getFechaNacimiento() %>		</td>
					<th></th>
					<td><%= cl.getEstado() %>		</td>
					
					<td><a class="btn btn-primary" href="/TP_INTEGRADOR_GRUPO_5/ModificarCliente.jsp?dni=<%=cl.getDni()%>">Modificar</a></td>
					<form method= "post" action="ServletClientes?Dni=<%=cl.getDni()%>">
					<td><input type="submit" name="btnEliminar" value="Eliminar" class="btn btn-danger" /></td>
					</form>
					
				</tr>
				<%  } %>
			</tbody>
	</table>
		<div>
			<a class="btn btn-primary" href="Inicio.jsp">Volver</a>
		</div>
	


</body>
</html>