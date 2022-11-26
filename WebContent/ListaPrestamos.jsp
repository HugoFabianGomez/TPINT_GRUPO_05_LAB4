<%@ page import="java.util.ArrayList"%>
<%@ page import="entidades.Prestamo"%>
<%@ page import="presentacion.controller.ServletPrestamos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<meta charset="UTF-8">
<title>Lista Prestamos</title>

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
</head>

<body>

	<jsp:include page="Menu.jsp"></jsp:include>
	<form method="get" action="ServletPrestamos">

		<%
			ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();

			if (request.getAttribute("listaPrestamos") != null) {
				listaPrestamos = (ArrayList<Prestamo>) request.getAttribute("listaPrestamos");
			}
		%>

		<div style="text-align: center">

			<table style="width: 100%; text-align: center"
				class="table table-striped table-bordered">
				<tbody>
					<tr>
						<td style="width: 60%">
							<div class="form-group">
								<div class="col-md-6">
									<label style="font-size: 20px;" class="form-label">Lista
										de Préstamos</label>
								</div>
							</div>
						</td>
						<td style="width: 40%">
							<div class="col-md-10">
								<div class="div-inline">
									<label for="txtBuscarCliente"
										style="margin-right: 7px; font-size: 20px;">Buscar
										cliente:</label> <input type="text" id="txtBuscarCliente"
										name="txtBuscarCliente">
								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>

			<div class="container" style="margin-top: 10px; padding: 5px">
				<table class="table table-dark table-hover"
					style="width: 100%; margin-top: 10px; padding: 5px">
					<thead>
						<tr>
							<th style="text-align: center; width: 150px;">Nro. de
								Préstamo</th>
							<th style="text-align: center">Cliente</th>
							<th style="text-align: center">Dni</th>
							<th style="text-align: center">Cuenta</th>
							<th style="text-align: center">Monto</th>
							<th style="text-align: center">Saldo</th>
							<th style="text-align: center">Estado</th>
							<th style="text-align: center; width: 200px;">Accion</th>
						</tr>
					</thead>
					<tbody>
						<%
							if (listaPrestamos != null)
								for (Prestamo p : listaPrestamos) {
						%>
						<tr>
							<td style="text-align: center; width: 150px;"><%=p.getCodigo()%></td>
							<td style="text-align: center"><%=p.getCliente().getNombreCompleto()%></td>
							<td style="text-align: center"><%=p.getCliente().getDni()%></td>
							<td style="text-align: center"><%=p.getCuenta().getNumeroCuenta()%></td>
							<td style="text-align: center"><%=p.getImportePagar()%></td>
							<td style="text-align: center"><%=p.getImportePagar()%></td>
							<td style="text-align: center"><%=p.getEstado()%></td>
							<td style="text-align: center; width: 200px;">
								<button type="button" id="DatosModalVerPrestamo"
									class="btn btn-primary" data-toggle="modal"
									data-target="#modalPrestamo"
									data-nombrecompleto="<%=p.getCliente().getNombreCompleto()%>"
									data-nroprestamo1="<%=p.getCodigo()%>"
									data-dni="<%=p.getCliente().getDni()%>"
									data-numerocuenta="<%=p.getCuenta().getNumeroCuenta()%>"
									data-importepagar="<%=p.getImportePagar()%>"
									data-estadoprestamo="<%=p.getEstado()%>"
									data-motivorechazo="<%=p.getMotivoRechazo()%>"
									data-cuotas="<%=p.getPlazoMeses()%>">
									<i class="fa-sharp fa-solid fa-eye"></i>
								</button> <a class="btn btn-primary"
								href="/TP_INTEGRADOR_GRUPO_5/ServletPrestamos?nroPre=<%=p.getCodigo()%>">
									<i class="fa-solid fa-money-bill"></i>
							</a> <%
 	if (p.getEstado() == "Pendiente") {
 %>
								<button type="button" id="DatosModalAutorizar"
									class="btn btn-success" data-toggle="modal"
									data-target="#modalAutorizar"
									data-nroprestamo="<%=p.getCodigo()%>">
									<i class="fa-solid fa-check"></i>
								</button>
								<button type="button" id="DatosModalRechazar"
									class="btn btn-danger" data-toggle="modal"
									data-target="#modalRechazar"
									data-nroprestamo2="<%=p.getCodigo()%>">
									<i class="fa-solid fa-trash"></i>
								</button> <%
 	}
 %>
							
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
			<div>
				<a class="btn btn-primary" href="Inicio.jsp">Volver</a>
			</div>
		</div>

		<!-- Modal autorizar-->
		<div class="modal fade" id="modalAutorizar" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<label for="NroPrestamoAutorizar">Autorizar prestamo N°</label> <input
							type="text" name="NroPrestamoAutorizar" id="NroPrestamoAutorizar"
							disabled="disabled"> <span aria-hidden="true"></span>
					</div>
					<div class="modal-body">
						<div class="modal-body" style="text-align: center">¿Estas
							seguro de autorizar el prestamo?</div>
						<div class="modal-footer">
							<button class="btn btn-secondary" type="button"
								data-dismiss="modal">Cancelar</button>
							<a class="btn btn-success" type="submit"
								onclick="window.location.href='/TP_INTEGRADOR_GRUPO_5/ServletPrestamos?aut='+NroPrestamoAutorizar.value;">Autorizar</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal rechazar-->
		<div class="modal fade" id="modalRechazar" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<label for="NroPrestamoRechazar">Rechazar prestamo N°</label> <input
							type="text" name="NroPrestamoRechazar" id="NroPrestamoRechazar"
							disabled="disabled"> <span aria-hidden="true"></span>
					</div>
					<div class="modal-body">
						<div class="modal-body" style="text-align: center">¿Estas
							seguro de rechazar el prestamo?</div>
						<div class="modal-footer">
							<button class="btn btn-secondary" type="button"
								data-dismiss="modal">Cancelar</button>
							<a class="btn btn-success" type="submit"
								onclick="window.location.href='/TP_INTEGRADOR_GRUPO_5/ServletPrestamos?rech='+NroPrestamoRechazar.value;">Rechazar</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal ver prestamo-->
		<div class="modal fade" id="modalPrestamo" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h2 id="VerNroPrestamo" style="text-align: center;"></h2>
					</div>
					<div class="modal-body" style="text-align: center;">
						</br> <label id="VerNombreCompleto"></label> </br> <label id="VerDni"></label>
						</br> <label id="VerNumeroCuenta"></label> </br> <label id="VerImportePagar"></label>
						</br> <label id="VerEstadoPrestamo"></label> </br> <label
							id="VerMotivoRechazo"></label> </br> <label id="VerCuotas"></label> </br>
						<div class="modal-footer">
							<button class="btn btn-success" type="button"
								data-dismiss="modal">Cerrar</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</form>

	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<!-- Bootstrap library -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

	<script>
		$(document).on("click", "#DatosModalAutorizar", function() {
			var nro_pre = $(this).data('nroprestamo');
			$("#NroPrestamoAutorizar").val(nro_pre);
		})

		$(document).on("click", "#DatosModalRechazar", function() {
			var nro_pre = $(this).data('nroprestamo2');
			$("#NroPrestamoRechazar").val(nro_pre);
		})

		$(document)
				.on(
						"click",
						"#DatosModalVerPrestamo",
						function() {
							var nombre_completo = $(this)
									.data('nombrecompleto');
							var nro_pre = $(this).data('nroprestamo1');
							var dni = $(this).data('dni');
							var numero_cuenta = $(this).data('numerocuenta');
							var importe_pagar = $(this).data('importepagar');
							var estado_prestamo = $(this)
									.data('estadoprestamo');
							var motivo_rechazo = $(this).data('motivorechazo');
							var cuotas1 = $(this).data('cuotas');
							$("#VerNombreCompleto").text(
									"Nombre Completo: " + nombre_completo);
							$("#VerNroPrestamo").text(
									"Numero de Prestamo: " + nro_pre);
							$("#VerDni").text("DNI: " + dni);
							$("#VerNumeroCuenta").text(
									"Numero Cuenta: " + numero_cuenta);
							$("#VerImportePagar").text(
									"Importe a Pagar: " + importe_pagar);
							$("#VerEstadoPrestamo").text(
									"Estado del Prestamo: " + estado_prestamo);
							$("#VerCuotas").text("Cuotas: " + cuotas1);
							$("#VerMotivoRechazo").text(
									"Motivo del Rechazo: " + motivo_rechazo);
						})
	</script>

</body>
</html>