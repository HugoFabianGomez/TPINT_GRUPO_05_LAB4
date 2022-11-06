<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Alta de Cliente</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="Menu.html"></jsp:include>
	<h3>Alta de Cliente</h3>
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
		<td>Nombre(s): </td>
		<td style="height: 0px; "><input type="text" name="txtNOMBRE"/></td>
		<td>Apellido(s): </td>
		<td style="height: 0px; "><input type="text" name="txtAPELLIDO"/></td>
	</tr>
	 
	<tr> 
		<td>Nacionalidad: </td>
		<td style="height: 0px; ">
			<select name="txtNACIONALIDAD" >
				<option value="0" >Seleccione Nacionalidad</option>
				<option value="1" >Argentino</option>
				<option value="2" >Brasilero</option>
					<!-- ACA DESARROLLO LAS OPCIONES -->									 				
			 </select>	
		</td>
		<td>Fecha de Nacimiento: </td>
		<td style="height: 0px; "><input type="date" name="txtFECHA_NAC" value="DD/MM/AAAA" /><br></td>
		<td>Género: </td>
		<td style="height: 0px; ">
			<select name="txtSEXO" >
			
			<option value="1" >Femenino</option>
			<option value="2" >Masculino</option>
			<option value="3" >No binario</option>
			<option value="4" >Transgénero</option>
			<option value="5" >Transexual</option>
			<option value="6" >Genero fluido</option>
			<option value="7" >Poligénero</option>
			<option value="8" >Agénero</option>
			<option value="9" >Género neutro</option>
			<option value="10" >Pangénero</option>
			
			
					<!-- ACA DESARROLLO LAS OPCIONES -->
			 </select>	
		</td>
		
	</tr>
	
	<tr>
		<td>Domicilio: </td>
		<td style="height: 0px; "><input type="text" name="txtDIRECCION" required  maxlength="40" autocomplete="off" /><br></td>
		<td style="height: 0px; ">
			<select name="txtLOCALIDAD" >
			<option value="1" >Localidad: </option>
					<!-- ACA DESARROLLO LAS OPCIONES -->									 				
			 </select>	
		</td>
		<td style="height: 0px; ">
			<select name="txtPROVINCIA" >
			<option value="1" >Provincia: </option>
					<!-- ACA DESARROLLO LAS OPCIONES -->									 				
			 </select>	
		</td>
	</tr>
	<tr>
		<td>Correo Electrónico: </td>
		<td style="height: 0px; ">  <input type="email" name="textEMAIL" required /> </td>	
	</tr>
	<tr> 
		<td>Teléfono: </td>
		<td style="height: 0px; "><input type="tel" name="txtTELEFONO"/></td>
	</tr>
	
	<tr>
		<td></td>
	</tr>
	<br />
	<tr>
		<td style="height: 0px; "><input type="submit" name="btnAceptar" value="Agregar"/></td>
	</tr>

</table>
</form>

</body>
</html>