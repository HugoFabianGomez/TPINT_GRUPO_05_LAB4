<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.TipoCuenta"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Agregar Cuenta</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	
	<jsp:include page="Menu.html"></jsp:include>
<h3>Agregar Cuenta</h3>

<form action="ServletCuentas" method="post">
<table>
	<tr> 
		<td style="width: 139px; ">Número de Cuenta: </td>
		<td style="height: 0px; "><input type="Number" name="txtNumeroCuenta"
		required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="0000000000" /><br></td>
		<td>CBU  </td>
		<td style="height: 0px; "><input type="Number" name="txtCBU" 
		required  maxlength="22" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="0000000000000000000000" /><br></td>
	
	<% 
	
		ArrayList<TipoCuenta> listaTipos = new ArrayList<TipoCuenta>();
		if(request.getAttribute("listaTipos")!=null){
			listaTipos = (ArrayList<TipoCuenta>)request.getAttribute("listaTipos");
		}
	
	%>
	</tr>
		<tr> 
		<td>Tipo de Cuenta: </td>
		<td style="height: 0px; ">
			<select name="txtTipoCuenta" >
				<%
					for(TipoCuenta tpCue : listaTipos){					
				 %>								 		
					<option value="<%=tpCue.getCodigo()%>"><%=tpCue.getDescripcion() %></option>		
				 <% 
					}
				 %>		
			 </select>
		</td>
		<td>Fecha de Creación: </td>
		<td style="height: 0px; "><input type="date" name="txtFechaCreacion" value="DD/MM/AAAA"/></td>
		
	</tr>
	 
	<tr> 
		<td>DNI del Cliente: </td>
		<td style="height: 0px; "><input type="Number" name="txtDNI" min="1" max="99999999"
		required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="00.000.000" /><br></td>
		<td>Saldo inicial: $10000</td>
	
	
	<tr> 
		<br><br>
		<td style="height: 0px; "><input type="submit" name="btnAgregar" onclick="return confirm('¿Está seguro que desea agregar esta cuenta?')" value="Agregar"/></td>
	</tr>

</table>
</form>
	
	<%
	if(request.getAttribute("filas")!=null){
	 %>
		Cuenta agregada exitosamente!
	<% 
	}
	%>

</body>
</html>