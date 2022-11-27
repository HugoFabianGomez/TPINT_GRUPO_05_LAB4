<%@ page import="java.util.ArrayList"%>
<%@ page import="entidades.Cuota"%>
<%@ page import="presentacion.controller.ServletPrestamos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cuotas</title>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<form method="get" action="ServletPrestamos">

		<%
			ArrayList<Cuota> listaCuotas = new ArrayList<Cuota>();

			if (request.getAttribute("listaCuotas") != null) {
				listaCuotas = (ArrayList<Cuota>) request.getAttribute("listaCuotas");
			}
		%>

		<div style="text-align: center">
			<table style="width: 100%; text-align: center"
				class="table table-striped table-bordered">
				<tbody>
					<tr>
						<td style="width: 60%">
							<div class="form-group">
								<div class="col-md-12">
									<label style="font-size: 20px;" class="form-label">Prestamo
										N°<%
										request.getParameter("nroPre");
									%>
									</label>
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
							<th style="text-align: center; width: 150px;">Nro. de Cuota</th>
							<th style="text-align: center">Importe Cuota</th>
							<th style="text-align: center">Saldo Cuota</th>
							<th style="text-align: center">Estado Cuota</th>
							<th style="text-align: center; width: 160px;">Accion</th>
						</tr>
					</thead>
					<tbody>
						<%
							if (listaCuotas != null)
								for (Cuota c : listaCuotas) {
						%>
						<tr>
							<td style="text-align: center"><%=c.getNumeroCuota()%></td>
							<td style="text-align: center"><%=c.getImporteCuota()%></td>
							<td style="text-align: center"><%=c.getSaldoCuota()%></td>
							<td style="text-align: center"><%=c.getEstadoCuota()%></td>
							<td class="text-center">
							
							<button type="button" id="DatosModalAutorizar"
									class="btn btn-success" data-toggle="modal"
									data-target="#modalPagarCuota"
									data-nroprestamo="<%=c.getCodigoCuota()%>">
									<i class="fa-solid fa-dollar-sign"></i>
								</button>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
			<div>
				</br> <a class="btn btn-primary" href="Inicio.jsp">Volver</a>
			</div>
		</div>

		<!-- Modal pagar cuota-->
		<div class="modal fade" id="modalPagarCuota" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<label for="NroCuota">Cuota N°</label> <input
							type="text" name="NroCuota" id="NroCuota"
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
	</form>
</body>
</html>