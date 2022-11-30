<%@page import="entidades.*"%>
<%@page import="negocio.*"%>
<%@page import="negocioImpl.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="presentacion.controller.ServletClientes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Perfil Usuario</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<%
		Usuario currenteUser = (Usuario) (session.getAttribute("usuario"));
		if(session.getAttribute("usuario") == null){
			response.sendRedirect("/TP_INTEGRADOR_GRUPO_5/Login.jsp");
			System.out.println("No hay usuario");
		} 		
			String Usuario = currenteUser.getNombreUsuario();
			ClienteNegocio clienteNegocio = new ClienteNegocioImpl();
	 		Cliente cl = clienteNegocio.obtenerUno(Usuario);
	%>
	<jsp:include page="Menu.jsp"></jsp:include>
<h3>PERFIL DEL USUARIO</h3>

<form action="ServletClientes" method="get">
<table>
	<tr> 
		<td style="width: 139px; "><h4>DNI</h4></td>
		<td style="height: 0px; "><input readonly type="Number" name="txtDNI" min="1" max="9999999999" value="<%= cl.getDni()%>" readonly
			required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
			class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/><br></td>
		<td><h4> CUIL </h4> </td>
		<td style="height: 0px; "><input readonly type="Number" name="txtCUIL" value="<%=cl.getCuil() %>"
			required  maxlength="12" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
			class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" /><br></td>

	</tr>
		<tr> 
		<td style="width: 139px; "><h4> NOMBRE/S </h4></td>
		<td style="height: 0px; "><input readonly type="text" name="txtNOMBRE"  value="<%=cl.getNombre() %>"
			class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
		<td><h4>APELLIDO/S</h4> </td>
		<td style="height: 0px; "><input readonly type="text" name="txtAPELLIDO"  value="<%=cl.getApellido() %>"
			class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
		
	</tr>
	 
	<tr> 
		<td><h4>NACIONALIDAD </h4></td>
		<td style="height: 0px; "><input readonly type="text" name="txtNACIONALIDAD"  value="<%=cl.getNacionalidad().getDescripcion() %>"
			class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
		
		<td><h4> FECHA NACIMIENTO </h4></td>
		<td style="height: 0px; "><input readonly type="date" name="txtFECHA_NAC"  value="<%=cl.getFechaNacimiento() %>"
			class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/><br></td>
		<td><h4> GENERO </h4></td>
		<td style="height: 0px; "><input readonly type="text" name="txtSEXO"  value="<%=cl.getGenero().getDescripcion()%>"
			class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
	</tr>	
	<tr>
		<td><h4> DOMICILIO </h4></td>
		<td style="height: 0px; "><input readonly type="text" name="txtDIRECCION"  value="<%=cl.getDomicilio() %>"
			class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/><br></td>
		<td><h4>Localidad</h4></td>
		<td style="height: 0px; "><input readonly type="text" name="txtLOCALIDAD"  value="<%=cl.getLocalidad().getDescripcion()%>"
			class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
		<td><h4>  Provincia</h4></td>
		<td style="height: 0px; "><input readonly type="text" name="txtPROVINCIA"  value="<%=cl.getProvincia().getDescripcion()%>"
			class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
	</tr>
	<tr>
		<td><h4> CORREO ELECTRONICO	</h4></td>
		<td style="height: 0px; ">  <input readonly type="email" name="textEMAIL" required value="<%=cl.getEmail() %>"
			class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" /> </td>	
	</tr>
	<tr> 
		<td><h4>TELEFONO </h4></td>
		<td style="height: 0px; "><input readonly type="tel" name="txtTELEFONO" value="<%=cl.getTelefono() %>"
			class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
	</tr>

</table>
		<div>
			<a class="btn btn-primary" href="Inicio.jsp"><h4> Volver </h4></a>
		</div>
</form>

</body>
</html>
