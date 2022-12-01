<%@ page import="java.util.ArrayList"%>
<%@ page import="entidades.Cuenta"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<!-- DATATABLES -->
<!--  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"> -->
<!-- BOOTSTRAP -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<style>
th, td {
	padding: 0.4rem !important;
}

body>div {
	box-shadow: 10px 10px 8px #888888;
	border: 2px solid black;
	border-radius: 10px;
}
</style>
<title>Lista de Cuentas</title>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<h2 style="text-align: center; margin-bottom: 20px;">Lista de
		Cuentas</h2>


	<%
		ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
		if (request.getAttribute("listaCuentas") != null) {
			listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listaCuentas");
		}
	%>

	<div class="container" style="margin-top: 10px; padding: 5px">
		<table id="tablax" class="table table-striped table-bordered"
			style="width: 100%">
			<thead>
				<tr>
					<th>Nro. de Cuenta</th>
					<th>CBU</th>
					<th>Tipo</th>
					<th>Fecha de Creación</th>
					<th>DNI del Cliente</th>
					<th>Saldo</th>
					<th>Estado</th>
					<%
						if (session.getAttribute("permiso").equals("Admin")) {
					%>
					<th></th>
					<th></th>
					<%
						}
					%>
				</tr>
			</thead>
			<tbody>
				<%
					for (Cuenta cuenta : listaCuentas) {
				%>
				<tr>

					<td align="center"><%=cuenta.getNumeroCuenta()%></td>
					<td align="center"><%=cuenta.getCbu()%></td>
					<td align="center"><%=cuenta.getTipoCuenta().getDescripcion()%></td>
					<td align="center"><%=cuenta.getFechaCreacion()%></td>
					<td align="center"><%=cuenta.getCliente().getDni()%></td>
					<td align="center"><%=cuenta.getSaldo()%></td>
					<%
						if (cuenta.getEstado() == true) {
					%>
					<td align="center">Activa</td>

					<%
						} else if (cuenta.getEstado() == false) {
					%>
					<td align="center">Inactiva</td>
					<%
						}
							if (session.getAttribute("permiso").equals("Admin")) {
					%>
					<td align="center"><a class="btn btn-primary"
						href="ServletCuentas?modificar=<%=cuenta.getNumeroCuenta()%>">Modificar</a>
					</td>

					<td align="center"><a class="btn btn-primary"
						onclick="return confirm('¿Está seguro que desea eliminar esta cuenta?')"
						href="ServletCuentas?eliminar=<%=cuenta.getNumeroCuenta()%>">Eliminar</a>
					</td>
					<%
						}
					%>
				</tr>
				<%
					}
				%>
			</tbody>

		</table>
		<div>
			<a class="btn btn-primary" href="Inicio.jsp">Volver</a>
		</div>

		<%
			boolean modifico = false;
			if (request.getAttribute("modifico") != null) {
				modifico = (Boolean) request.getAttribute("modifico");
				if (modifico == false) {
		%>
		<div class="mb-3">
			<label class="form-label">Error al modificar cuenta..</label>
		</div>
		<%
			} else if (modifico == true) {
		%>
		<div class="mb-3">
			<label class="form-label">Cuenta modificada con éxito!</label>
		</div>

		<%
			}
			}
		%>

		<%
			if (request.getAttribute("elimino") != null) {
		%>
		<div class="mb-3">
			<label class="form-label">Cuenta eliminada correctamente!</label>
		</div>
		<%
			}
		%>

	</div>

</body>
<!-- JQUERY -->
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous">
	
</script>
<!-- DATATABLES -->
<script
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js">
	
</script>
<!-- BOOTSTRAP -->
<script
	src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js">
	
</script>
<script>
	$(document)
			.ready(
					function() {
						$('#tablax')
								.DataTable(
										{
											language : {
												processing : "Tratamiento en curso...",
												search : "Buscar&nbsp;:",
												lengthMenu : "Agrupar de _MENU_ items",
												info : "Mostrando del item _START_ al _END_ de un total de _TOTAL_ items",
												infoEmpty : "No existen datos.",
												infoFiltered : "(filtrado de _MAX_ elementos en total)",
												infoPostFix : "",
												loadingRecords : "Cargando...",
												zeroRecords : "No se encontraron datos con tu busqueda",
												emptyTable : "No hay datos disponibles en la tabla.",
												paginate : {
													first : "Primero",
													previous : "Anterior",
													next : "Siguiente",
													last : "Ultimo"
												},
												aria : {
													sortAscending : ": active para ordenar la columna en orden ascendente",
													sortDescending : ": active para ordenar la columna en orden descendente"
												}
											},
											scrollY : 400,
											lengthMenu : [ [ 10, 25, -1 ],
													[ 10, 25, "All" ] ],
										});
					});
</script>
</html>