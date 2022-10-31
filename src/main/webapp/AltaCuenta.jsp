<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Agregar Cuenta</title>
</head>
<body>
	
	<jsp:include page="Navegacion.jsp"></jsp:include>
<h3>ALTA CUENTA</h3>

<form action="servletSeguro" method="get">
<table>
	<tr> 
		<td style="width: 139px; ">NUMERO DE CUENTA</td>
		<td style="height: 0px; "><input type="Number" name="txtNumeroCuenta"
		required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="0000000000" /><br></td>
		<td>CBU  </td>
		<td style="height: 0px; "><input type="Number" name="txtCBU" 
		required  maxlength="22" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="0000000000000000000000" /><br></td>

	</tr>
		<tr> 
		<td>TIPO DE CUENTA </td>
		<td style="height: 0px; ">
			<select name="txtNACIONALIDAD" >
					<!-- DESARROLLO OPCIONES TIPO DE CUENTA -->									 				
			 </select>
		</td>
		<td>FECHA DE CREACION </td>
		<td style="height: 0px; "><input type="date" name="txtFechaCreacion" value="DD/MM/AAAA"/></td>
		
	</tr>
	 
	<tr> 
		<td>DNI DEL CLIENTE</td>
		<td style="height: 0px; "><input type="Number" name="txtDNI" min="1" max="99999999"
		required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="00.000.000" /><br></td>
		
		
	</tr>
	
	
	<tr> 
		<br><br>
		<td style="height: 0px; "><input type="submit" name="btnAceptar" value="AGREGAR"/></td>
	</tr>

</table>
</form>
	
</body>
</html>