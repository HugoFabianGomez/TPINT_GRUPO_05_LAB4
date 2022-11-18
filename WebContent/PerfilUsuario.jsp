<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Genero"%>
<%@page import="negocio.GeneroNegocio"%>
<%@page import="negocioImpl.GeneroNegocioImpl"%>
<%@page import="entidades.Nacionalidad"%>
<%@page import="negocio.NacionalidadNegocio"%>
<%@page import="negocioImpl.NacionalidadNegocioImpl"%>
<%@page import="entidades.Provincia"%>
<%@page import="negocio.ProvinciaNegocio"%>
<%@page import="negocioImpl.ProvinciaNegocioImpl"%>
<%@page import="entidades.Localidad"%>
<%@page import="negocio.LocalidadNegocio"%>
<%@page import="negocioImpl.LocalidadNegocioImpl"%>
<%@page import="entidades.Cliente"%>
<%@page import="presentacion.controller.ServletClientes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Perfil Usuario</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

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


	<jsp:include page="Menu.html"></jsp:include>
<h3>PERFIL DEL USUARIO</h3>

<form action="ServletClientes" method="get">
<table>
	<tr> 
		<td style="width: 139px; ">DNI</td>
		<td style="height: 0px; "><input readonly type="Number" name="txtDNI" min="1" max="9999999999" value="<%=request.getParameter("dni")%>" readonly
		required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="00.000.000" /><br></td>
		<td>CUIL  </td>
		<td style="height: 0px; "><input readonly type="Number" name="txtCUIL" value="<%=cl.getCuil() %>"
		required  maxlength="12" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="00000000000" /><br></td>

	</tr>
		<tr> 
		<td style="width: 139px; ">NOMBRE/S </td>
		<td style="height: 0px; "><input readonly type="text" name="txtNOMBRE"  value="<%=cl.getNombre() %>"/></td>
		<td>APELLIDO/S </td>
		<td style="height: 0px; "><input readonly type="text" name="txtAPELLIDO"  value="<%=cl.getApellido() %>"/></td>
		
	</tr>
	 
	<tr> 
		<td>NACIONALIDAD</td>
		<td style="height: 0px; "><input readonly type="text" name="txtNACIONALIDAD"  value="<%=cl.getNacionalidad().getDescripcion() %>"/></td>
		
		<td>FECHA NACIMIENTO</td>
		<td style="height: 0px; "><input readonly type="date" name="txtFECHA_NAC"  value="<%=cl.getFechaNacimiento() %>"/><br></td>
		<td>GENERO </td>
		<td style="height: 0px; "><input readonly type="text" name="txtSEXO"  value="<%=cl.getGenero().getDescripcion() %>"/></td>
	</tr>	
	<tr>
		<td>DOMICILIO </td>
		<td style="height: 0px; "><input readonly type="text" name="txtDIRECCION" required  maxlength="40" autocomplete="off" value="<%=cl.getDomicilio() %>"/><br></td>
		<td style="height: 0px; "><input readonly type="text" name="txtLOCALIDAD"  value="<%=cl.getLocalidad().getDescripcion() %>"/></td>
		
		<td style="height: 0px; "><input readonly type="text" name="txtPROVINCIA"  value="<%=cl.getProvincia().getDescripcion()  %>"/></td>
	</tr>
	<tr>
		<td>CORREO ELECTRONICO	</td>
		<td style="height: 0px; ">  <input readonly type="email" name="textEMAIL" required value="<%=cl.getEmail() %>" /> </td>	
	</tr>
	<tr> 
		<td>TELEFONO </td>
		<td style="height: 0px; "><input readonly type="tel" name="txtTELEFONO" value="<%=cl.getTelefono() %>"/></td>
	</tr>
	<tr> 
		<form>
		<td class="common-button secondary"><input type="submit" name="btnModificar" value="MODIFICAR"/></td>
		</form>
	</tr>
</table>
</form>

</body>
</html>
