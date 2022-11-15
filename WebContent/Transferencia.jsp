<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nueva Transferencia</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<h1>Nueva Transferencia</h1>
<form action="servletSeguro" method="get">
<table>
	<tr> 
		<td>Desde: </td>
		<td style="height: 0px; ">
			<select name="txtSEXO" >
			
			<option value="1" >Cuenta 1</option>
			<option value="2" >Cuenta 2</option>
			<!-- ACA DESARROLLO LAS OPCIONES -->
			</select>	
		</td>
		
	</tr>
	<tr> 
		<td>Hacia: </td>
		<td style="height: 0px; ">
			<select name="txtSEXO" >
			
			<option value="1" >Cuenta 1</option>
			<option value="2" >Cuenta 2</option>
			<!-- ACA DESARROLLO LAS OPCIONES -->
			</select>	
		</td>
		
	</tr>
	<tr>
		<td>Monto: </td>
		<td style="height: 0px; ">  <input type="number" name="textMONTO" required /></td>	
	</tr>	
	<br />
	<tr>
		<td style="height: 0px; "><input type="submit" name="btnConfirmar" value="Confirmar"/></td>
	</tr>

</table>
</form>

</body>
</html>