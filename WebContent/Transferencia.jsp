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
		if(currentUser==null){
			response.sendRedirect("/TP_INTEGRADOR_GRUPO_5/Login2.jsp");
			System.out.println("No hay usuario");
		} else {%>
<body>
				<% 
				if(currentUser.getNombreUsuario() != "lemos.h")
				{
					ClienteNegocio clienteNegocio = new ClienteNegocioImpl();
					String Usuario = currentUser.getNombreUsuario();
					Cliente cl = clienteNegocio.obtenerUno(Usuario);
					
					CuentaNegocio ctaNegocio = new CuentaNegocioImpl();
					int dni = cl.getDni();
					ArrayList<Cuenta> ctLista = ctaNegocio.obtenerTodos(dni);
					
					for(Cuenta cta : ctLista)
					{
						System.out.println(cta.toString());
					}
				%>
				  	<header class="card shadows">
					 	<h1>Bienvenido <%=currentUser.getNombreUsuario()%></h1>
					 	<form action="/TP_INTEGRADOR_GRUPO_5/ServletLogin" method="POST">
							<button type="submit" name="cerrarSesion" class="common-button danger">Cerrar sesion</button>
						</form>
					 </header>
	 
	 
					 <section id="inicio" class="row">	 
						<div class="col card shadows">
							<div class="row-center ">
									<jsp:include page="Menu.html"></jsp:include>
									<h1>Nueva Transferencia</h1>				
							</div>
						</div>
					 </section>
					<form action="servletSeguro" method="get">
					<table>
							<tr>
							<td style="width: 139px; ">	TITULAR:</td>
							</tr>
							<TR>
							<td style="width: 139px; ">Nombre y Apellido </td>
							<td style="height: 0px; "><input type="text" name="txtNOMBRE"  value="<%=cl.getApellido() +", "+cl.getNombre() %>" readonly /></td>
							<td style="width: 139px; ">Dni.</td>
							<td style="height: 0px; "><input type="text" name="txtNOMBRE"  value="<%=cl.getDni() %>" readonly /></td>
							</TR>
							<tr>
							<td style="width: 139px; ">Cuentas:</td> 
							</tr>
							<tr>
							<td style="width: 139px; ">Cuentas Origen</td> 
							<td style="height: 0px; ">
							<select name="txtNACIONALIDAD" >
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
								<td style="height: 0px; ">  <input type="number" name="textMONTO" required /></td>	
							</tr>
						
							<br />
							
							<br>
							
							<tr>
							<td style="height: 0px; "><input type="submit" name="btnConfirmar" value="Confirmar"/></td>
						</tr>
					
					</table>
					</form>
					
				
				
				
				
				
				<%} 
				
				}%>
				









</body>
</html>