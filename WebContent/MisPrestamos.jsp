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
	<jsp:include page="Menu.jsp"></jsp:include>
	<form method="get" action="ServletPrestamos">

		<%
			ArrayList<Prestamo> listaMisPrestamos = new ArrayList<Prestamo>();

			if (request.getAttribute("listaMisPrestamos") != null) {
				listaMisPrestamos = (ArrayList<Prestamo>) request.getAttribute("listaMisPrestamos");
			}
		%>

		<table style="width: 100%" class="table table-striped table-bordered">
			<tbody>
				<tr>
					<td style="width: 99%">
						<div class="form-group">
							<div class="col-md-6">
								<label style="font-size: 20px;" class="form-label">Cliente:
									<%=request.getAttribute("labelCliente")%></label>
							</div>
						</div>
					</td>
					<td style="width: 1%">
						<div class="col-md-1">
							<div class="shortcuts">
								<a
									href="ServletPrestamos?dni=<%=request.getAttribute("dniActual")%>"><input
									type="button" name="btnNuevo" class="btn btn-success"
									value="Nuevo prestamo" /></a>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>

		<div style="text-align: center">
			<h1>Mis Prestamos</h1>

			</br>

			<table class="table table-dark table-hover" border="1" width="900">
				<thead>
					<tr>
						<th style="text-align: center; height: 70px;">Nro. de Préstamo</th>
						<th style="text-align: center">Cliente</th>
						<th style="text-align: center">Dni</th>
						<th style="text-align: center">Cuenta</th>
						<th style="text-align: center">Monto</th>
						<th style="text-align: center">Saldo</th>
						<th style="text-align: center">Estado</th>
						<th style="text-align: center">Accion</th>

					</tr>
				</thead>
				<tbody>
					<%
						if (listaMisPrestamos != null)
							for (Prestamo p : listaMisPrestamos) {
					%>
					<tr>
						<td style="text-align: center; height: 70px;"><%=p.getCodigo()%></td>
						<td style="text-align: center"><%=p.getCliente().getNombreCompleto()%></td>
						<td style="text-align: center"><%=p.getCliente().getDni()%></td>
						<td style="text-align: center"><%=p.getCuenta().getNumeroCuenta()%></td>
						<td style="text-align: center"><%=p.getImportePagar()%></td>
						<td style="text-align: center"><%=p.getImportePagar()%></td>
						<td style="text-align: center"><%=p.getEstado()%></td>
						<td class="text-center" style="width: 100px;">
							<button type="submit" id="btnVisualizar" class="btn btn-info">
								<i class="fa-solid fa-magnifying-glass"></i>
							</button> <a class="btn btn-primary"
							href="/TP_INTEGRADOR_GRUPO_5/ServletPrestamos?nroPre=<%=p.getCodigo()%>">
								<i class="fa-solid fa-dollar-sign"></i>
						</a>
						</td>
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
	</form>

</body>
</html>