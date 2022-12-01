<%@page import="java.util.ArrayList"%>
<%@page import=" javax.swing.JOptionPane"%>
<%@page import="entidades.*"%>
<%@page import="negocio.*"%>
<%@page import="negocioImpl.*"%>
<%@page import="presentacion.controller.*"%>
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
			if(session.getAttribute("userid")==null || session.getAttribute("permiso")=="NoAdmin")
			{
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			}
			
		ArrayList<Genero> list_Genero =             (ArrayList<Genero>)         ServletGeneros.obtenerGeneros();
		ArrayList<Nacionalidad> list_Nacionalidad = (ArrayList<Nacionalidad>) ServletNacionalidades.obtenerNacionalidades();	
		ArrayList<Localidad> list_Localidad =       (ArrayList<Localidad>)      ServletLocalidades.obtenerLocalidades();
		ArrayList<Provincia> list_Provincia =       (ArrayList<Provincia>)      ServletProvincias.obtenerProvincia();	
		
		%>

	<jsp:include page="Menu.jsp"></jsp:include>
	<h3>Alta de Cliente</h3>
<form action="ServletClientes" method="post">
<table>
	
	<tr> 
		<td style="width: 139px; "><h4>DNI</h4> </td>
		<td style="height: 0px; ">
		<input type="Number" name="txtDNI" min="1" max="99999" maxlength="5"
		required   autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="00000" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" />
		</td>
		<%
			/*	PARA VERIFICAR SI EL DINI CARGADO SE ENCUENTRA EN LA BASE
			ClienteNegocio ClienteNeg = new ClienteNegocioImpl();
			boolean existe = false;
			existe= ClienteNeg.existe(Boolean.parseBoolean("txtDNI").tos);
			if(existe == true){
				JOptionPane.showMessageDialog(null, "Entre al jsp de Alta Cliente");
			}*/
		%>
		<td><h4>CUIL  </h4></td>
		<td style="height: 0px; "><input type="Number" name="txtCUIL" min="1" max="30999999"
		required  maxlength="8" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="00000000" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" /></td>

	</tr>
	<tr> 
		<td><h4>Nombre(s): </h4> </td>
		<td style="height: 0px; "><input type="text" name="txtNOMBRE" style="text-transform:uppercase" required="required"
		class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
		<td><h4>Apellido(s):</h4>  </td>
		<td style="height: 0px; "><input type="text" name="txtAPELLIDO" style="text-transform:uppercase" required="required"
		class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
	</tr>
	<tr> 
		<td> <h4>Nacionalidad: </h4> </td>
		<td style="height: 0px; ">
			<select name="txtNACIONALIDAD" required class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
				<%
					if(list_Nacionalidad!=null){
						for (Nacionalidad nac : list_Nacionalidad) {
				%>
							<option value="<%=nac.getCodigo()%>"><%=nac.getDescripcion()%></option>
				<%
						}
					}
				%>					 				
			 </select>	
		</td>
		<td><h4>Fecha Nacimiento</h4></td>
		<td style="height: 0px; "><input type="date" name="txtFECHA_NAC" value="DD/MM/AAAA" required
		class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/><br></td>
		<td><h4>  Género:</h4> </td>
		<td style="height: 0px; ">
			<select name="txtGENERO" required class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
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
		<td> <h4>Domicilio: </h4></td>
		<td style="height: 0px; "><input type="text" name="txtDIRECCION" required  maxlength="40" autocomplete="off" style="text-transform:uppercase"
			class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
		<td><h4>Localidad</h4></td>
		<td style="height: 0px; ">
			<select name="txtLOCALIDAD" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
				<%
				if(list_Localidad!=null){
					for (Localidad loc : list_Localidad) {
				%>
					<option value="<%=loc.getCodigo()%>"><%=loc.getDescripcion()%></option>
				<%
					}
				}
					%>
			</select>	
		</td>
		<td><h4>  Provincia</h4></td>
		<td style="height: 0px; ">
			<select name="txtPROVINCIA" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
			<%
				if(list_Provincia!=null)
					for (Provincia prov : list_Provincia) {
				%>
					<option value="<%=prov.getCodigo()%>"><%=prov.getDescripcion()%></option>
				<% } %>								 				
			 </select>	
		</td>
	</tr>
	<tr>
		<td><h4> Correo Electrónico:</h4> </td>
		<td style="height: 0px; ">  <input type="email" name="textEMAIL" required 
		class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/> </td>	
	</tr>
	<tr> 
		<td><h4>Teléfono: </h4> </td>
		<td style="height: 0px; "><input type="tel" name="txtTELEFONO" required
		class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
	</tr>
	<tr>
		<td><h4>Usuario: </h4></td>
		<td style="height: 0px; ">  <input type="text" name="textUSUARIO" required 
		class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/> </td>	
		<td> <input type="text" readonly value="CLAVE = DNI" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
	</tr>

	<tr>
		<td style="height: 0px; "><input type="submit" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"
			onclick="return confirm('Confirme Alta de Nuevo Cliente.')" name="btnAceptar" value="Agregar"/></td>
	</tr>

</table>
</form>
		
</body>
</html>
