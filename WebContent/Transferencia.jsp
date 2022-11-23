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
	<title>Nueva Transferencia</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
	<% 
		Usuario currentUser = (Usuario)(session.getAttribute("usuario"));
		if(session.getAttribute("usuario") !=null){
		System.out.println("currentUser= " + currentUser.getNombreUsuario());
		} else if(currentUser ==null){
			
			response.sendRedirect("/TP_INTEGRADOR_GRUPO_5/Login.jsp");
			System.out.println("No hay usuario");
		} else %>
<body>
				<% 
				//System.out.println("Que tengo en Transferencia ln.29= "+loginUser.getNombreUsuario());
				if(session.getAttribute("permiso").equals("NoAdmin"))
				{
					ClienteNegocio clienteNegocio = new ClienteNegocioImpl();
					String Usuario = currentUser.getNombreUsuario();
					System.out.println("Usuario ln 31= "+Usuario);
					Cliente cl = clienteNegocio.obtenerUno(Usuario);
					
					CuentaNegocio ctaNegocio = new CuentaNegocioImpl();
					int dni = cl.getDni();
					ArrayList<Cuenta> ctLista = ctaNegocio.obtenerTodos(dni);
					
				%>
				  	<header class="card shadows">
					 	<h1>Bienvenido </h1>
					 	<form action="/TP_INTEGRADOR_GRUPO_5/ServletLogin" method="POST">
							<button type="submit" name="cerrarSesion" class="common-button danger">Cerrar sesion</button>
						</form>
					 </header>
	 
	 
					 <section id="inicio" class="row">	 
						<div class="col card shadows">
							<div class="row-center ">
							<jsp:include page="Menu.jsp"></jsp:include>
									<h1>Nueva Transferencia</h1>				
							</div>
						</div>
					 </section>
					<form action="ServletMovimientos" method="get">
					<table>
							<tr>
							<td style="width: 139px; ">	TITULAR:</td>
							</tr>
							<TR>
							<td style="width: 139px; ">Nombre y Apellido </td>
							<td style="height: 0px; "><input type="text" name="txtNOMBRE"  value="<%= cl.getNombre() %>" readonly /></td>
							<td style="height: 0px; "><input type="text" name="txtAPELLIDO"  value="<%= cl.getApellido() %>" readonly /></td>
							<td style="width: 139px; ">Dni.</td>
							<td style="height: 0px; "><input type="text" name="txtDNI"  value="<%=cl.getDni() %>" readonly /></td>
							</TR>
							<tr>
							<td style="width: 139px; ">Cuentas:</td> 
							</tr>
							<tr>
							<td style="width: 139px; ">Cuentas Origen</td> 
							<td style="height: 0px; ">
							<select name="txtCuenta" >
								<%				
								if(ctLista !=null)
									for (Cuenta cta : ctLista) {
								%>
									<option value="<%=cta.getNumeroCuenta()%>"  ><%= cta.getNumeroCuenta()+"-" +cta.getTipoCuenta().getDescripcion() +" Saldo:  $ "+ cta.getSaldo()%></option>
								<%}	%>									 				
							 </select>	
							</td>							
							
							</tr>
							<tr>
							<td style="width: 139px; ">Cuentas Destino</td>
							<tr>
							<td style="width: 139px; ">C.B.U.:</td>
							<td style="height: 0px; "><input type="text" name="txtCbuDestino" /></td>
							<td>Importe a Transferir: </td>
								<td style="height: 0px; ">  <input type="number" name="textImporteTransferencia" required /></td>	
							<tr>
							<td style="width: 139px; ">Detalle:</td>
							<td style="height: 0px; "><input type="text" name="txtDetalle" /></td>
							
							<tr>
							<td style="height: 0px; "><input type="submit" name="btnTranferencia" value="Confirmar"/></td>
						</tr>
					
					</table>
					</form>
					
				
				
				
				
				
				<%} 
				
				%>
				









</body>
</html>