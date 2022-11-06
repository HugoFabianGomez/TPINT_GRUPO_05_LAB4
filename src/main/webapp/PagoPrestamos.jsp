<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>

<script>
	function addDate() {
		date = new Date();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var year = date.getFullYear();

		if (document.getElementById('datetext').value == '') {
			document.getElementById('datetext').value = day + '-' + month + '-'
					+ year;
		}
	}
</script>

<head>
<meta charset="UTF-8">
<title>Solicitud Prestamo</title>
</head>
<body onload="addDate();">
	<jsp:include page="Menu.html"></jsp:include>
	<h3>SOLICITUD PRESTAMO</h3>

	<form action="servletSeguro" method="get">
		<table>
			<tr>
			</tr>

			<tr>
				<td>CLIENTE</td>
				<td style="height: 0px;">
					<select name="sltCliente">
						<!-- Se desarrolara la aparicion del cliente -->
					</select>
				</td>

				<td>CUENTA</td>
				<td style="height: 0px;">
					<select name="sltCuenta">
						<option value="0" >Seleccione una Cuenta</option>
						<option value="1" >Cta   $ xxxxxxxxxxxxxx</option>
						<option value="2" >Cta US$ yyyyyyyyyyyyyy</option>
					</select></td>

			</tr>

			<tr>
				<td>SELECCIONE CUOTA</td>
				<td style="height: 0px;">
					<select name="sltCuotas">
						<!-- La cuota se podra traer por sistema -->
					</select></td>
			</tr>

			<tr>
				<td>MONTO</td>
					<!-- El monto de La cuota se podra traer por sistema -->
				<td style="height: 0px;"><input type="text" name="txtMonto" 
					autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"/><br></td>
			</tr>

			<tr>
				<td>FECHA</td>
				<!-- La fecha se trae del sisitema sistema -->
				<td style="height: 0px;"><input type="text" id="datetext"><br></td>
			</tr>

			<tr>
				<td style="height: 0px;"><input type="submit"
					name="btnAutorizar" value="Autorizar" /></td>
			</tr>

		</table>
	</form>
</body>
</html>