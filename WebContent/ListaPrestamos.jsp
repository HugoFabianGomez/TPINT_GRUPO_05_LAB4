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
<title>Lista Prestamos</title>
</head>
<body>

	<script type="text/javascript">
		function openModalDetallePrestamo() {
			$('[id*=ModalDetallePrestamo]').modal('show');
		}
		function closeModalStockHistorico() {
			$('[id*=ModalDetallePrestamo]').modal('hide');
		}
	</script>

	<jsp:include page="Menu.jsp"></jsp:include>
	<form method="get" action="ServletPrestamos">

		<%
			ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();

			if (request.getAttribute("listaPrestamos") != null) {
				listaPrestamos = (ArrayList<Prestamo>) request.getAttribute("listaPrestamos");
			}
		%>

		<div style="text-align: center">

			<table style="width: 100%" class="table table-striped table-bordered">
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

			<table class="table table-dark table-hover" border="1" width="900">
				<thead>
					<tr>
						<th style="text-align: center; width: 150px;">Nro. de
							Préstamo</th>
						<th style="text-align: center">Cliente</th>
						<th style="text-align: center">Dni</th>
						<th style="text-align: center">Cuenta</th>
						<th style="text-align: center">Monto</th>
						<th style="text-align: center">Saldo</th>
						<th style="text-align: center; width: 160px;">Accion</th>
					</tr>
				</thead>
				<tbody>
					<%
						if (listaPrestamos != null)
							for (Prestamo p : listaPrestamos) {
					%>
					<tr>
						<td style="text-align: center"><%=p.getCodigo()%></td>
						<td style="text-align: center"><%=p.getCliente().getNombreCompleto()%></td>
						<td style="text-align: center"><%=p.getCliente().getDni()%></td>
						<td style="text-align: center"><%=p.getCuenta().getNumeroCuenta()%></td>
						<td style="text-align: center"><%=p.getImportePagar()%></td>
						<td style="text-align: center"><%=p.getImportePagar()%></td>
						<td class="text-center"><a id="btnAutorizar" class="btn btn-info" data-toggle="modal"
							data-target="#modalAutorizar"> <i class="fa-solid fa-check"></i>
						</a> <a id="btnRechazar" class="btn btn-info" data-toggle="modal"
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

		<!-- Modal autorizar-->
		<div class="modal fade" id="modalAutorizar" role="dialog">
			<div class="modal-dialog">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"></button>
						<h2 class="modal-title" id="exampleModalLabel">Autorizar</h2>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true"></span>
						</button>
					</div>
					<div class="modal-body" style="text-align: center">¿Estas
						seguro de autorizar el prestamo?</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancelar</button>
						<a class="btn btn-primary" href="Login.jsp">Autorizar</a>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal rechazar-->
		<div class="modal fade" id="modalRechazar" role="dialog">
			<div class="modal-dialog">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"></button>
						<h2 class="modal-title" id="exampleModalLabel">Rechazar</h2>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true"></span>
						</button>
					</div>
					<div class="modal-body" style="text-align: center">¿Estas
						seguro de rechazar el prestamo?</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancelar</button>
						<a class="btn btn-primary" href="Login.jsp">Rechazar</a>
					</div>
				</div>
			</div>
		</div>

	</form>

</body>
</html>