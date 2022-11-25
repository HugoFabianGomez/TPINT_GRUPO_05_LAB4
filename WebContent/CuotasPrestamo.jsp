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

			<table style="width: 100%" class="table table-striped table-bordered">
				<tbody>
					<tr>
						<td style="width: 60%">
							<div class="form-group">
								<div class="col-md-12">
									<label style="font-size: 20px;" class="form-label">Prestamo N°<%request.getAttribute("nroPre");%></label>
								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>

			<table class="table table-dark table-hover" border="1" width="900">
				<thead>
					<tr>
						<th style="text-align: center; width: 150px;">Nro. de
							Cuota</th>
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
						<td class="text-center">  <a id="btnRechazar" class="btn btn-info" data-toggle="modal"
							data-target="#modalRechazar"> <i class="fa-solid fa-xmark"></i>
						</a>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<div>
				</br> <a class="btn btn-primary" href="Inicio.jsp">Volver</a>
			</div>
		</div>

		<!-- Modal pago cuota-->
		<div class="modal fade" id="modalAutorizar" role="dialog">
			<div class="modal-dialog">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"></button>
						<h2 class="modal-title" id="exampleModalLabel">Pago de cuota</h2>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true"></span>
						</button>
					</div>
					<div class="modal-body" style="text-align: center">¿Estas
						seguro de pagar la cuota?</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancelar</button>
						<a class="btn btn-primary" href="Login.jsp">Pagar</a>
					</div>
				</div>
			</div>
		</div>

	</form>

</body>
</html>