<%@page import="java.util.ArrayList"%>
<%@page import="entidades.*"%>
<%@page import="negocio.*"%>
<%@page import="negocioImpl.*"%>
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
			if(session.getAttribute("userid")==null || session.getAttribute("permiso")=="NoAdmin")
			{
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			}
		%>
	<%
	GeneroNegocio generoNegocio = new GeneroNegocioImpl();
	ArrayList<Genero> list_Genero = generoNegocio.obtenerTodos();

	NacionalidadNegocio nacNegocio = new NacionalidadNegocioImpl();
	ArrayList<Nacionalidad> list_Nacionalidad = nacNegocio.obtenerTodos();

	ProvinciaNegocio provNegocio = new ProvinciaNegocioImpl();
	ArrayList<Provincia> list_Provincia = provNegocio.obtenerTodos();

	LocalidadNegocio locNegocio = new LocalidadNegocioImpl();
	ArrayList<Localidad> list_Localidad = locNegocio.obtenerLocalidad();
		
		String dni = request.getParameter("dni");
 		Cliente cl = ServletClientes.obtenerCliente(dni);
 		
	%>


	<jsp:include page="Menu.jsp"></jsp:include>
<h3>MODIFICAR CLIENTE</h3>

<form action="ServletClientes" method="get">
<table>
	<tr> 
		<td style="width: 139px; "><h4>DNI</h4></td>
		<td style="height: 0px; "><input type="Number" name="txtDNI" min="1" max="9999999999" value="<%=request.getParameter("dni")%>" readonly
		class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"
		required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="00.000.000" /><br></td>
		<td><h4>CUIL</h4>  </td>
		<td style="height: 0px; "><input type="Number" name="txtCUIL" value="<%=cl.getCuil() %>"
		class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"
		required  maxlength="12" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="00000000000" /><br></td>

	</tr>
		<tr> 
		<td style="width: 139px; "><h4>NOMBRE /S</h4></td>
		<td style="height: 0px; "><input type="text" name="txtNOMBRE"  value="<%=cl.getNombre() %>"
		class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
		<td><h4>APELLIDO /S</h4> </td>
		<td style="height: 0px; "><input type="text" name="txtAPELLIDO"  value="<%=cl.getApellido() %>"
		class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
		
	</tr>
	 
	<tr> 
		<td><h4></h4>NACIONALIDAD</td>
		<td style="height: 0px; ">
			<select name="txtNACIONALIDAD" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
				<%				
				if(list_Nacionalidad!=null)
					for (Nacionalidad nac : list_Nacionalidad) {
				%>

					<option value="<%=nac.getCodigo()%>" <%=nac.getCodigo()==cl.getNacionalidad().getCodigo()?"selected":"" %>><%=nac.getDescripcion()%></option>

				<%}	%>									 				
			 </select>	
		</td>
		<td><h4>FECHA NACIMIENTO</h4></td>
		<td style="height: 0px; "><input type="date" name="txtFECHA_NAC"  value="<%=cl.getFechaNacimiento() %>"
		class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/><br></td>
		<td><h4>GENERO</h4> </td>
		<td style="height: 0px; ">
			<select name="txtSEXO" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
				<%
				if(list_Genero!=null)
					for (Genero gen : list_Genero) {
				%>
					<option class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"
					value="<%=gen.getCodigo()%>" <%=gen.getCodigo()==cl.getGenero().getCodigo()?"selected":"" %>><%=gen.getDescripcion()%></option>
				<% }%>
			 </select>	
		</td>
		
	</tr>
	
	<tr>
		<td><h4>DOMICILIO</h4> </td>
		<td style="height: 0px; "><input type="text" name="txtDIRECCION" required  maxlength="40" autocomplete="off" value="<%=cl.getDomicilio() %>"/><br></td>
		<td><h4>Localidad</h4></td>
		<td style="height: 0px; ">
			<select name="txtLOCALIDAD" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
				<%
				if(list_Localidad!=null)
					for (Localidad loc : list_Localidad) {
				%>
					<option value="<%=loc.getCodigo()%>" <%=loc.getCodigo()==cl.getLocalidad().getCodigo()?"selected":"" %>><%=loc.getDescripcion()%></option>
				<%} %>
												 				
			 </select>	
		</td>
		<td><h4>  Provincia</h4></td>
		<td style="height: 0px; ">
			<select name="txtPROVINCIA" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
					<%
				if(list_Provincia!=null)
					for (Provincia prov : list_Provincia) {
				%>
					<option value="<%=prov.getCodigo()%>" <%=prov.getCodigo()==cl.getProvincia().getCodigo()?"selected":"" %>><%=prov.getDescripcion()%></option>
				<% } %>

					<!-- ACA DESARROLLO LAS OPCIONES -->									 				
			 </select>	
		</td>
	</tr>
	<tr>
		<td><h4>CORREO ELECTRONICO</h4></td>
		<td style="height: 0px; ">  <input type="email" name="textEMAIL" required value="<%=cl.getEmail() %>" /> </td>	
	</tr>
	<tr> 
		<td><h4>TELEFONO</h4> </td>
		<td style="height: 0px; "><input type="tel" name="txtTELEFONO" value="<%=cl.getTelefono() %>"/></td>
	</tr>
	<tr>
		<td></td>
	</tr>
	<tr> 
		<br><br>
		<form>
		<td class="common-button secondary"><input type="submit" name="btnModificar" value="MODIFICAR"/></td>
		</form>
	</tr>

</table>
</form>

</body>
</html>
