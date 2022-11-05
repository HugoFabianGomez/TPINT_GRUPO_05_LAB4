<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Detalle pago</title>
</head>
<body onload="addDate();">
	<jsp:include page="Menu.html"></jsp:include>

	<form action="servletSeguro" method="get">
		<table>
			<tr>
			</tr>

			<tr>
				<td>CLIENTE</td>
				<td style="height: 0px;"><input type="text" name="txtCliente"/><br></td>
			</tr>
			
			<tr>
			<td>CUENTA</td>
				<td style="height: 0px;"><input type="text" name="txtCuenta"/><br></td>
			</tr>

			<tr>
				<td>CUOTA</td>
				<td style="height: 0px;"><input type="text" name="txtCuota"/><br></td>		
			</tr>

			<tr>
				<td>MONTO</td>
				<td style="height: 0px;"><input type="text" name="txtMonto"/><br></td>
			</tr>

			<tr>
				<td>FECHA DE PAGO</td>
				<td style="height: 0px;"><input type="text" id="txtFechaPago"><br></td>
			</tr>

			<tr>
				<td style="height: 0px;"><input type="submit"
					name="btnVolver" value="Volver" /></td>
			</tr>

		</table>
	</form>
</body>
</html>