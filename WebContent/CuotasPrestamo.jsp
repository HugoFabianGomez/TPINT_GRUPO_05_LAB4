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

			String nro_prestamo = request.getParameter("nroPre");
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
										N°<%=nro_prestamo%>
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
							<th style="text-align: center">Cuenta</th>
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
							<td style="text-align: center"><%=c.getNumeroCuenta()%></td>
							<td style="text-align: center"><%=c.getEstadoCuota()%></td>
							<td class="text-center">
								<%
									if (c.getSaldoCuota() > 0.00) {
								%>
								<button type="button" id="functionPagarPrestamo"
									class="btn btn-success" data-toggle="modal"
									data-target="#modalPagarCuota"
									data-nrocuota="<%=c.getNumeroCuota()%>"
									data-nroprestamo="<%=c.getNumeroPrestamo()%>" data-saldocuota="<%=c.getSaldoCuota()%>" 
									data-nrocuenta="<%=c.getNumeroCuenta()%>">
									<i class="fa-solid fa-dollar-sign"></i>
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
				<a class="btn btn-primary" type="submit"
					href="ServletPrestamos?mp=1">Volver</a>
			</div>
		</div>

		<!-- Modal pagar cuota-->
		<div class="modal fade" id="modalPagarCuota" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<input type="hidden" id="nroPrestamo2" /> <input type="hidden"
							id="nroCuota2" />
							<input type="hidden" id="nroCuenta2" />
						<h2 id="lblCuota"></h2>
					</div>
					<div class="modal-body">
						<label for="txtMontoPagar">Monto a pagar: </label> <input
							id="txtMontoPagar" name="txtMontoPagar"
							oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						<div class="modal-body" style="text-align: center">¿Estas
							seguro de pagar la cuota?</div>
						<div class="modal-footer">
							<button class="btn btn-secondary" type="button"
								data-dismiss="modal">Cancelar</button>
							<a class="btn btn-success" type="submit"
								onclick="window.location.href='/TP_INTEGRADOR_GRUPO_5/ServletPrestamos?cuo='+nroCuota2.value+'&pres='+nroPrestamo2.value+'&txtMonto='+txtMontoPagar.value+'&nroCuenta='+nroCuenta2.value">Pagar</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

	<script>
		$(document).on("click", "#functionPagarPrestamo", function() {
			var nro_cuota = $(this).data('nrocuota');
			var nro_prestamo = $(this).data('nroprestamo');
			var saldo_cuota = $(this).data('saldocuota');
			var numero_cuenta = $(this).data('nrocuenta');
			$("#lblCuota").text("Cuota N°" + nro_cuota)
			$("#nroPrestamo2").val(nro_prestamo);
			$("#nroCuota2").val(nro_cuota);
			$("#nroCuenta2").val(numero_cuenta);
			$("#txtMontoPagar").attr({
				"max" : saldo_cuota, 
				"min" : 0
			});
		})
	</script>

</body>
</html>