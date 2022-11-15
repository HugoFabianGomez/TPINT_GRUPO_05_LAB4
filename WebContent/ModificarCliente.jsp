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
<%@page import="presentacion.controller.ServletClientes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<%
		ArrayList<Genero> list_Genero = (ArrayList<Genero>) ServletGeneros.obtenerGeneros();
		ArrayList<Nacionalidad> list_Nacionalidad = (ArrayList<Nacionalidad>) ServletNacionalidades.obtenerNacionalidades();
		ArrayList<Provincia> list_Provincia = (ArrayList<Provincia>) ServletProvincias.obtenerProvincia();
		ArrayList<Localidad> list_Localidad = (ArrayList<Localidad>) ServletLocalidades.obtenerLocalidades();
		
		String dni = request.getParameter("dni");
 		Cliente cl = ServletClientes.obtenerCliente(Integer.parseInt(dni));
 		
	%>


	<jsp:include page="Menu.jsp"></jsp:include>
<h3>MODIFICAR CLIENTE</h3>

<form action="ServletClientes" method="get">
<table>
	<tr> 
		<td style="width: 139px; ">DNI</td>
		<td style="height: 0px; "><input type="Number" name="txtDNI" min="1" max="9999999999" value="<%=request.getParameter("dni")%>" readonly
		required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="00.000.000" /><br></td>
		<td>CUIL  </td>
		<td style="height: 0px; "><input type="Number" name="txtCUIL" value="<%=cl.getCuil() %>"
		required  maxlength="12" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="00000000000" /><br></td>

	</tr>
		<tr> 
		<td>NOMBRE/S </td>
		<td style="height: 0px; "><input type="text" name="txtNOMBRE"  value="<%=cl.getNombre() %>"/></td>
		<td>APELLIDO/S </td>
		<td style="height: 0px; "><input type="text" name="txtAPELLIDO"  value="<%=cl.getApellido() %>"/></td>
		
	</tr>
	 
	<tr> 
		<td>NACIONALIDAD</td>
		<td style="height: 0px; ">
			<select name="txtNACIONALIDAD" >
				<%				
				if(list_Nacionalidad!=null)
					for (Nacionalidad nac : list_Nacionalidad) {
				%>
					<option value="<%=nac.getCodigo()%>"><%=nac.getDescripcion()%></option>
				<%}	%>									 				
			 </select>	
		</td>
		<td>FECHA NACIMIENTO</td>
		<td style="height: 0px; "><input type="date" name="txtFECHA_NAC" value="DD/MM/AAAA" value="<%=cl.getFechaNacimiento() %>"/><br></td>
		<td>GENERO </td>
		<td style="height: 0px; ">
			<select name="txtSEXO" >
				<%
				if(list_Genero!=null)
					for (Genero gen : list_Genero) {
				%>
					<option value="<%=gen.getCodigo()%>"><%=gen.getDescripcion()%></option>
				<% }%>
			 </select>	
		</td>
		
	</tr>
	
	<tr>
		<td>DOMICILIO </td>
		<td style="height: 0px; "><input type="text" name="txtDIRECCION" required  maxlength="40" autocomplete="off" value="<%=cl.getDomicilio() %>"/><br></td>
		<td style="height: 0px; ">
			<select name="txtLOCALIDAD" >
				<%
				if(list_Localidad!=null)
					for (Localidad loc : list_Localidad) {
				%>
					<option value="<%=loc.getCodigo()%>"><%=loc.getDescripcion()%></option>
				
				<%} %>
												 				
			 </select>	
		</td>
		<td style="height: 0px; ">
			<select name="txtPROVINCIA" >
					<%
				if(list_Provincia!=null)
					for (Provincia prov : list_Provincia) {
				%>
					<option value="<%=prov.getCodigo()%>"><%=prov.getDescripcion()%></option>
				<% } %>

					<!-- ACA DESARROLLO LAS OPCIONES -->									 				
			 </select>	
		</td>
	</tr>
	<tr>
		<td>CORREO ELECTRONICO	</td>
		<td style="height: 0px; ">  <input type="email" name="textEMAIL" required value="<%=cl.getEmail() %>" /> </td>	
	</tr>
	<tr> 
		<td>TELEFONO </td>
		<td style="height: 0px; "><input type="tel" name="txtTELEFONO" value="<%=cl.getTelefono() %>"/></td>
	</tr>
	<tr>
		<td></td>
	</tr>
	<tr> 
		<br><br>
		<td style="height: 0px; "><input type="submit" name="btnModificar" value="MODIFICAR"/></td>
	</tr>

</table>
</form>

</body>
</html>
