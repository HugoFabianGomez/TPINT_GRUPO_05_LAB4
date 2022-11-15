<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entidades.Cuenta" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="Menu.html"></jsp:include>
<h3>MODIFICAR CUENTA</h3>



<%
	Cuenta cuenta = new Cuenta();
	if(request.getAttribute("cuenta")!=null){
		cuenta = (Cuenta)request.getAttribute("cuenta"); 
	}

%>
<form action="ServletCuentas" method="post">
<table>
	<tr> 
		<td style="width: 169px; ">NUMERO DE CUENTA</td>
		<td style="height: 0px; "><input type="Number" name="txtNumeroCuenta"
		required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="<%=cuenta.getNumeroCuenta() %>" /><br></td>
		<td>CBU  </td>
		<td style="height: 0px; "><input type="Number" name="txtCBU" 
		required  maxlength="22" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="<%=cuenta.getCbu() %>" /><br></td>

	</tr>
		<tr> 
		<td>TIPO DE CUENTA </td>
		<td style="height: 0px; ">
			<select name="txtTipoCuenta">
				<option value="0" >Seleccione Tipo de Cuenta</option>
				
				<%
				if(cuenta.getTipoCuenta().getCodigo()==1){
				%>
					<option value="1" selected>Caja de Ahorro</option>
					<option value="2" >Cuenta Corriente</option>
				<%
				}
				else{ 
				%>
					<option value="1" >Caja de Ahorro</option>
					<option value="2" selected>Cuenta Corriente</option>
				<%
				}
				 %>
					<!-- DESARROLLO OPCIONES TIPO DE CUENTA -->									 				
			 </select>
		</td>
		<td>FECHA DE CREACION </td>
		<td style="height: 0px; "><input type="date" name="txtFechaCreacion" value="<%=cuenta.getFechaCreacion() %>"/></td>
		
	</tr>
	 
	<tr> 
		<td>DNI DEL CLIENTE</td>
		<td style="height: 0px; "><input type="Number" name="txtDNI" min="1" max="99999999"
		required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
		value="<%=cuenta.getCliente().getDni() %>" /><br></td>
		
		
	</tr>
	<tr>
		<td>SALDO</td>
		<td><input type="Number" name="txtSaldo"
		autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))" value="<%=cuenta.getSaldo() %>"/></td>
		<td>ESTADO</td>
		<td>
			<select name="comboEstado">
				<option> --SELECCIONE ESTADO--</option>
				<%
				if(cuenta.getEstado()==true){
				%>
					<option value=1 selected> Activa </option>
					<option value=0> Inactiva </option>
				<% 
				}
				else{
				 %>
				<option value=1> Activa </option>
				<option value=0 selected> Inactiva </option>
				<%
				}
				 %>
			</select>
		</td>
	</tr>
	<tr> 
		<td style="height: 0px; "><input type="submit" name="btnConfirmarModificar"  value="MODIFICAR"/></td>
	</tr>

</table>
</form>
	

</body>
</html>
