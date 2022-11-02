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
<title>Pago prestamo</title>
</head>
<body onload="addDate();">
	<jsp:include page="Navegacion.jsp"></jsp:include>
	<h3>PAGO PRESTAMO</h3>

	<form action="servletSeguro" method="get">
		<table>
			<tr>
			</tr>

			<tr>
				<td>CLIENTE</td>
				<td style="height: 0px;"><select name="sltCliente">

				</select></td>

				<td>CUENTA</td>
				<td style="height: 0px;"><select name="sltCuenta">

				</select></td>

			</tr>

			<tr>
				<td>SELECCIONE CUOTA</td>
				<td style="height: 0px;"><select name="sltCuotas">
				</select></td>
			</tr>

			<tr>
				<td>MONTO</td>
				<td style="height: 0px;"><input type="text" name="txtMonto" 
					autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"/><br></td>
			</tr>

			<tr>
				<td>FECHA</td>
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