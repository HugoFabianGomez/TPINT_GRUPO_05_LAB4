<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Nacionalidad"%>
<%@page import="entidades.Provincia"%>
<%@page import="entidades.Genero"%>
<%@page import="entidades.Localidad"%>
<%@page import="entidades.Cliente"%>
<%@page import="presentacion.controller.ServletNacionalidades"%>
<%@page import="presentacion.controller.ServletProvincias"%>
<%@page import="presentacion.controller.ServletGeneros"%>
<%@page import="presentacion.controller.ServletLocalidades"%>
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

<%

ArrayList<Genero> list_Genero = (ArrayList<Genero>) ServletGeneros.obtenerGeneros();
ArrayList<Nacionalidad> list_Nacionalidad = (ArrayList<Nacionalidad>) ServletNacionalidades.obtenerNacionalidades();
ArrayList<Provincia> list_Provincia = (ArrayList<Provincia>) ServletProvincias.obtenerProvincia();
ArrayList<Localidad> list_Localidad = (ArrayList<Localidad>) ServletLocalidades.obtenerLocalidades();

%>

	<jsp:include page="Menu.jsp"></jsp:include>
	<h3>Alta de Cliente</h3>
<form action="ServletClientes" method="post">
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
		<td style="height: 0px; "><input type="text" name="txtNOMBRE" style="text-transform:uppercase"/></td>
		<td>Apellido(s): </td>
		<td style="height: 0px; "><input type="text" name="txtAPELLIDO" style="text-transform:uppercase"/></td>
	</tr>
	 
	<tr> 
		<td>Nacionalidad: </td>
		<td style="height: 0px; ">
			<select name="txtNACIONALIDAD" required>
			
				<%
				if(list_Nacionalidad!=null)
					for (Nacionalidad nac : list_Nacionalidad) {
				%>
					<option value="<%=nac.getCodigo()%>"><%=nac.getDescripcion()%></option>
				<%
					}
					%>
								 				
			 </select>	
		</td>
		<td>Fecha de Nacimiento: </td>
		<td style="height: 0px; "><input type="date" name="txtFECHA_NAC" value="DD/MM/AAAA" required/><br></td>
		<td>Género: </td>
		<td style="height: 0px; ">
			<select name="txtGENERO" required >
				<%
				if(list_Genero!=null)
					for (Genero gen : list_Genero) {
				%>
					<option value="<%=gen.getCodigo()%>"><%=gen.getDescripcion()%></option>
				<%
					}
					%>

			 </select>	
		</td>
		
	</tr>
	
	<tr>
		<td>Domicilio: </td>
		<td style="height: 0px; "><input type="text" name="txtDIRECCION" required  maxlength="40" autocomplete="off" style="text-transform:uppercase"/><br></td>
		<td style="height: 0px; ">
			<select name="txtLOCALIDAD" >
			<option value="1" >Localidad: </option>
			
				<%
				if(list_Localidad!=null)
					for (Localidad loc : list_Localidad) {
				%>
					<option value="<%=loc.getCodigo()%>"><%=loc.getDescripcion()%></option>
				<%
					}
					%>
					<!-- ACA DESARROLLO LAS OPCIONES -->									 				
			 </select>	
		</td>
		<td style="height: 0px; ">
			<select name="txtPROVINCIA" >
			
			<%
				if(list_Provincia!=null)
					for (Provincia prov : list_Provincia) {
				%>
					<option value="<%=prov.getCodigo()%>"><%=prov.getDescripcion()%></option>
				<%
					}
					%>
			
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
		<td>Usuario: </td>
		<td style="height: 0px; ">  <input type="text" name="textUSUARIO" required /> </td>	
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
