<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Navegacion.jsp"></jsp:include>
<h3>ALTA CLIENTE</h3>

<form action="servletSeguro" method="get">
<table>
	<tr> 
		<td style="width: 139px; ">DNI</td>
		<td style="height: 0px; "><input type="Number" name="txtDNI" min="1" max="99999999"
		required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="00.000.000" /><br></td>
		<td>CUIL  </td>
		<td style="height: 0px; "><input type="Number" name="txtCUIL" 
		required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="00-00000000-0" /><br></td>

	</tr>
		<tr> 
		<td>NOMBRE/S </td>
		<td style="height: 0px; "><input type="text" name="txtNOMBRE"/></td>
		<td>APELLIDO/S </td>
		<td style="height: 0px; "><input type="text" name="txtAPELLIDO"/></td>
		
	</tr>
	
	<!--  <tr> 
		<td>Descripcion </td>
		<td style="height: 0px; "><input type="text" name="txtDescripcion"/></td>
	</tr> -->
	<tr> 
		<td>NACIONALIDAD</td>
		<td style="height: 0px; ">
			<select name="txtNACIONALIDAD" >
					<!-- ACA DESARROLLO LAS OPCIONES -->									 				
			 </select>	
		</td>
		<td>FECHA NACIMIENTO</td>
		<td style="height: 0px; "><input type="date" name="txtFECHA_NAC" value="DD/MM/AAAA" /><br></td>
		<td>SEXO </td>
		<td style="height: 0px; ">
			<select name="txtSEXO" >
					<!-- ACA DESARROLLO LAS OPCIONES -->									 				
			 </select>	
		</td>
		
	</tr>
	
	<tr>
		<td>DOMICILIO </td>
		<td style="height: 0px; "><input type="text" name="txtDIRECCION" required  maxlength="40" autocomplete="off" /><br></td>
		<td style="height: 0px; ">
			<select name="txtLOCALIDAD" >
					<!-- ACA DESARROLLO LAS OPCIONES -->									 				
			 </select>	
		</td>
		<td style="height: 0px; ">
			<select name="txtPROVINCIA" >
					<!-- ACA DESARROLLO LAS OPCIONES -->									 				
			 </select>	
		</td>
	</tr>
	<tr>
		<td>CORREO ELECTRONICO	</td>
		<td style="height: 0px; ">  <input type="email" name="textEMAIL" required /> </td>	
	</tr>
	<tr> 
		<td>TELEFONO </td>
		<td style="height: 0px; "><input type="tel" name="txtTELEFONO"/></td>
	</tr>
	
	<tr> 
		<td></td>
		<td style="height: 0px; "><input type="submit" name="btnAceptar" value="AGREGAR"/></td>
	</tr>

</table>
</form>

</body>
</html>