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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<script>
	function addDate() {
		date = new Date();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var year = date.getFullYear();

		if (document.getElementById('txtFecha').value == '') {
			document.getElementById('txtFecha').value = day + '-' + month + '-'
					+ year;
		}
	}
</script>

<script type="text/javascript">
	function update() {
		var monto = document.getElementById('txtMonto');
		var intereses = document.getElementById('txtIntereses');
		var cuotas = document.getElementById('ddlCuotas');
		
		if (cuotas.value == 1) {
			intereses.value = (parseFloat(monto.value) * 1.1).toFixed(2);
		} else if (cuotas.value == 3) {
			intereses.value = (parseFloat(monto.value) * 1.3).toFixed(2);
		} else if (cuotas.value == 6) {
			intereses.value = (parseFloat(monto.value) * 1.6).toFixed(2);
		} else if (cuotas.value == 12) {
			intereses.value = (parseFloat(monto.value) * 2.2).toFixed(2);
		} else if (cuotas.value == 18) {
			intereses.value = (parseFloat(monto.value) * 2.8).toFixed(2);
		} else if (cuotas.value == 24) {
			intereses.value = (parseFloat(monto.value) * 3.4).toFixed(2);
		} else if (cuotas.value == 36) {
			intereses.value = (parseFloat(monto.value) * 4.6).toFixed(2);
		}		
	}
</script>

<head>
<meta charset="UTF-8">
<title>Nuevo prestamo</title>
</head>
<body onload="addDate();">
	<jsp:include page="Menu.html" />

	<h2>Nuevo prestamo</h2>

	<%
		if (request.getAttribute("listaCuentas") != null) {
			ArrayList<Cuenta> listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listaCuentas");
		}
	%>
	<form>
		<div class="row">
			<div class="col-md-6">
				<div class="mb-3">
					<label class="form-label">Cliente: <%=request.getAttribute("labelCliente")%></label>
				</div>

				<div class="mb-3">
					<label for="ddlCuentas" class="form-label">Cuentas</label> <select
						name="ddCuentas" class="form-select">

						<c:forEach items="${listaCuentas}" var="ddlCuentas">
							<option value="${ddlCuentas.numeroCuenta}">${ddlCuentas.numeroCuenta}</option>
						</c:forEach>
					</select>

				</div>

				<div class="mb-3">
					<label for="txtMonto" class="form-label">Monto</label> <input
						type="text" class="form-control" id="txtMonto" name="txtMonto" required
						maxlength="40" autocomplete="off" onchange="update();"
						oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
				</div>

				<div class="mb-3">
					<button type="submit" name="btnAceptar" class="btn btn-success">Agregar</button>
					<button type="button" name="btnCancelar" class="btn btn-danger">Cancelar</button>
				</div>
			</div>

			<div class="col-md-6">

				<div>
					<label for="ddlCuotas" class="form-label">Cuotas</label> <select
						id="ddlCuotas" name="cuotas" class="form-select">

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
						type="text" class="form-control" id="txtIntereses" name="txtIntereses" required
						maxlength="15" autocomplete="on" 
						oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
				</div>

				<div class="mb-3">
					<label for="txtFecha" class="form-label">Fecha</label> <input
						type="text" class="form-control" id="txtFecha" name="txtFecha">
				</div>
			</div>
		</div>

		<%
	if(request.getAttribute("filas")!=null){
	 %>
		Prestamo agregado exitosamente!
	<% 
	}
	%>

	</form>
</body>
</html>