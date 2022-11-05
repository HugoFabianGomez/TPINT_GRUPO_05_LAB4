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
<title>Autorizar prestamo</title>
</head>
<body onload="addDate();">
	<jsp:include page="Menu.html"></jsp:include>
	<h3>AUTORIZAR PRESTAMO</h3>

	<form action="servletSeguro" method="get">
		<table>
			<tr>
			</tr>

			<tr>
				<td>Cliente</td>
				<td style="height: 0px;"><select name="sltCliente">

				</select></td>
				
				<td>Cuenta</td>
				<td style="height: 0px;"><select name="sltCuenta">

				</select></td>
				
			</tr>
			<tr>
				<td>Monto</td>
				<td style="height: 0px;"><input type="text" name="txtMonto"
					required maxlength="40" autocomplete="off" /><br></td>
			</tr>

			<tr>
				<td>Cuotas</td>
				<td style="height: 0px;"><select name="sltCuotas">

						<option value="1">1</option>
						<option value="2">3</option>
						<option value="3">6</option>
						<option value="4">9</option>
						<option value="5">12</option>
						<option value="6">18</option>
						<option value="7">24</option>
						<option value="8">36</option>

				</select></td>
			</tr>

			<tr>
				<td>Intereses</td>
				<td style="height: 0px;"><input type="text" name="txtIntereses"
					required maxlength="15" autocomplete="on" /><br></td>
			</tr>

			<tr>
				<td>Fecha</td>
				<td style="height: 0px;"><input type="text" id="datetext"><br></td>
			</tr>

			<tr>
				<br>
				<br>
				<td style="height: 0px;"><input type="submit" name="btnAutorizar"
					value="Autorizar" /></td>
			</tr>

		</table>
	</form>
</body>
</html>