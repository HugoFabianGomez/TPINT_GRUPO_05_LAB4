<%@ page import="java.util.ArrayList"%>
<%@ page import="entidades.Prestamo"%>
<%@ page import="presentacion.controller.ServletPrestamos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mis Prestamos</title>
</head>
<body>
	<%
		ArrayList<Prestamo> listaMisPrestamos = new ArrayList<Prestamo>();

		if (request.getAttribute("listaMisPrestamos") != null) {
			listaMisPrestamos = (ArrayList<Prestamo>) request.getAttribute("listaMisPrestamos");
			String dni = String.valueOf(request.getAttribute("dniActual"));
		}
	%>

	<jsp:include page="Menu.jsp"></jsp:include>
	<h1>Mis Prestamos</h1>

	<form method="get" action="ServletPrestamos">

		<label class="form-label">Cliente: <%=request.getAttribute("labelCliente")%></label>
		<a href="ServletPrestamos?dni=<%=request.getAttribute("dniActual")%>"><input type="button" name="btnNuevo" class="btn btn-success"
			value="Nuevo prestamo" /></a> <br>

		<table border="1" width="900">
			<thead>
				<tr>
					<th>Nro. de Préstamo</th>
					<th style="width: 139px;">Cliente</th>
					<th>Cuenta</th>
					<th>Monto</th>
					<th style="width: 139px;">Saldo</th>
					<th>Acción 1</th>
					<th>Acción 2</th>
				</tr>
			</thead>
			<tbody>
				<%  
					if(listaMisPrestamos!=null)
					for(Prestamo p : listaMisPrestamos) 
				{%>
				<tr>
					<td><%=p.getCodigo() %></td>
					<td><%=p.getCliente().getNombreCompleto() %></td>
					<td><%=p.getCuenta().getNumeroCuenta() %></td>
					<td><%=p.getImportePedido() %></td>
					<td><%=p.getImportePagar() %></td>
					<td><input type="submit" name="btnAutorizar"
						class="btn btn-success" value="Autorizar" /></td>
					<td><input type="submit" name="btnRechazar"
						class="btn btn-danger" value="Rechazar" /></td>
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