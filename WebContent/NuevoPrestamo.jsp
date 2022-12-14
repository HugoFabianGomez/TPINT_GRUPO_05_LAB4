<%@ page import="java.util.ArrayList"%>
<%@ page import="entidades.Cliente"%>
<%@ page import="entidades.Prestamo"%>
<%@ page import="entidades.Cuenta"%>
<%@ page import="negocio.CuentaNegocio"%>
<%@ page import="negocio.ClienteNegocio"%>
<%@ page import="negocioImpl.CuentaNegocioImpl"%>
<%@ page import="negocioImpl.ClienteNegocioImpl"%>
<%@ page import="presentacion.controller.ServletPrestamos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo prestamo</title>
</head>
<body onload="addDate();">
	<jsp:include page="Menu.jsp"></jsp:include>

	<%
		ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();

		if (request.getAttribute("listaCuentas") != null) {
			listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listaCuentas");
		}

		String dni = String.valueOf(request.getAttribute("dniCliente"));
	%>

	<form method="post" action="ServletPrestamos">
		<h2 style="text-align: center; margin-bottom: 20px;">Nuevo
			prestamo</h2>

		<div class="row"
			style="margin: auto; width: 60%; border: 3px solid #73AD21; padding: 10px">
			<div class="col-md-6">
				<div class="mb-3">
					<label class="form-label">Cliente: <%=request.getAttribute("labelCliente")%></label>
				</div>

				<div class="mb-3">
					<label id="lblDni" class="form-label">DNI: <%=dni%></label> <input
						type="hidden" id="DniValue" name="DniValue" value="<%=dni%>" />
				</div>

				<div class="mb-3">
					<label for="ddlCuentas" class="form-label">Cuentas</label> <select
						required="required" name="ddlCuentas" class="form-select">
						<%
							if (listaCuentas != null)
								for (Cuenta c : listaCuentas) {
						%>
						<option value="<%=c.getNumeroCuenta()%>"><%=c.getNumeroCuenta()%></option>
						<%
							}
						%>
					</select>

				</div>

				<div class="mb-3">
					<label for="txtMonto" class="form-label">Monto</label> <input
						type="text" class="form-control" id="txtMonto" name="txtMonto"
						required maxlength="40" autocomplete="off" onchange="update();"
						required="required"
						oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
				</div>

				<div class="mb-3">
					<button type="submit" name="btnAceptar" class="btn btn-success">Agregar</button>
					<a class="btn btn-danger" type="submit"
						href="ServletPrestamos?mp=1">Cancelar</a>
				</div>
			</div>

			<div class="col-md-6">

				<div>
					<label for="ddlCuotas" class="form-label">Cuotas</label> <select
						required="required" id="ddlCuotas" name="cuotas"
						class="form-select">
						<option value="1">1</option>
						<option value="3">3</option>
						<option value="6">6</option>
						<option value="12">12</option>
						<option value="18">18</option>
						<option value="24">24</option>
						<option value="36">36</option>
					</select>
				</div>

				<div class="mb-3">
					<label for="txtIntereses" class="form-label">Intereses</label> <input
						required="required" type="text" class="form-control"
						id="txtIntereses" name="txtIntereses" required maxlength="15"
						autocomplete="on" readonly
						oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
				</div>

				<div class="mb-3">
					<label for="txtFecha" class="form-label">Fecha</label> <input
						required="required" type="text" class="form-control" id="txtFecha"
						name="txtFecha">
				</div>
			</div>
		</div>

		<%
			if (request.getAttribute("filas") != null) {
		%>
		Prestamo agregado exitosamente!
		<%
			}
		%>
	</form>

	<script>
		function addDate() {
			date = new Date();
			var month = date.getMonth() + 1;
			var day = date.getDate();
			var year = date.getFullYear();

			if (document.getElementById('txtFecha').value == '') {
				document.getElementById('txtFecha').value = day + '-' + month
						+ '-' + year;
			}
		}
	</script>

	<script type="text/javascript">
		function update() {
			var monto = document.getElementById('txtMonto');
			var intereses = document.getElementById('txtIntereses');
			var cuotas = document.getElementById('ddlCuotas');

			if (cuotas.value == 1) {
				intereses.value = ((parseFloat(monto.value) * 1.1) - monto.value)
						.toFixed(2);
			} else if (cuotas.value == 3) {
				intereses.value = ((parseFloat(monto.value) * 1.3) - monto.value)
						.toFixed(2);
			} else if (cuotas.value == 6) {
				intereses.value = ((parseFloat(monto.value) * 1.6) - monto.value)
						.toFixed(2);
			} else if (cuotas.value == 12) {
				intereses.value = ((parseFloat(monto.value) * 2.2) - monto.value)
						.toFixed(2);
			} else if (cuotas.value == 18) {
				intereses.value = ((parseFloat(monto.value) * 2.8) - monto.value)
						.toFixed(2);
			} else if (cuotas.value == 24) {
				intereses.value = ((parseFloat(monto.value) * 3.4) - monto.value)
						.toFixed(2);
			} else if (cuotas.value == 36) {
				intereses.value = ((parseFloat(monto.value) * 4.6) - monto.value)
						.toFixed(2);
			}
		}
	</script>

</body>
</html>