<%@ page import="daoImpl.ClienteDaoImpl"%>
<%@ page import="entidades.Cliente"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<head>
<meta charset="UTF-8">
<title>Autorizar prestamo</title>
</head>
<body onload="addDate();">
	<jsp:include page="Menu.html"></jsp:include>
	<h2>Autorizacion de prestamos</h2>

	<%
		ClienteDaoImpl cliDao = new ClienteDaoImpl();
		ArrayList<Cliente> listaClientes = null;

		listaClientes = (request.getAttribute("listaClientes") != null)
				? (ArrayList<Cliente>) request.getAttribute("listaClientes")
				: cliDao.obtenerTodos();
	%>

	<form>

		<div class="row">
			<div class="col-md-6">
				<div class="mb-3">
					<label for="ddlClientes" class="form-label">Clientes</label> <select
						name="ddlClientes" class="form-select">
						<%
							for (Cliente c : listaClientes) {
								dni = String.valueOf(c.getDni());
						%>
						<option value="<%=dni%>"><%=c.getNombreCompleto()%>
						</option>
						<%
							}
						%>
					</select>

				</div>

				<div class="mb-3">
					<label for="ddlCuentas" class="form-label">Cuentas</label> <select
						class="form-select" name="ddlCuentas">
					</select>
				</div>

				<div class="mb-3">
					<label for="txtMonto" class="form-label">Monto</label> <input
						type="text" class="form-control" name="txtMonto" required
						maxlength="40" autocomplete="off" />
				</div>

				<div class="mb-3">
					<button type="button" ID="btnAutorizar" class="btn btn-success">Autorizar</button>
					<button type="button" ID="btnAutorizar" class="btn btn-danger">Cancelar</button>
				</div>
			</div>

			<div class="col-md-6">

				<div>
					<label for="ddlCuotas" class="form-label">Cuotas</label> <select
						name="ddlCuotas" class="form-select">

						<option value="1">1</option>
						<option value="2">3</option>
						<option value="3">6</option>
						<option value="5">12</option>
						<option value="6">18</option>
						<option value="7">24</option>
						<option value="8">36</option>

					</select>
				</div>

				<div class="mb-3">
					<label for="txtIntereses" class="form-label">Intereses</label> <input
						type="text" class="form-control" name="txtIntereses" required
						maxlength="15" autocomplete="on" />
				</div>

				<div class="mb-3">
					<label for="txtFecha" class="form-label">Fecha</label> <input
						type="text" class="form-control" id="txtFecha">
				</div>
			</div>
		</div>
	</form>
</body>
</html>