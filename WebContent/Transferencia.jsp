<%@page import="javax.swing.JOptionPane"%>
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
<body>
				<% 
					Usuario currentUser = (Usuario)(session.getAttribute("usuario"));
						
				
				if(session.getAttribute("usuario") !=null && session.getAttribute("permiso").equals("Admin")){
					//System.out.println("currentUser= " + currentUser.getNombreUsuario());
					JOptionPane.showMessageDialog(null, "Esta Opcion es del Perfil Cliente");
					System.out.println("Esta Opcion es del Perfil Cliente");
					response.sendRedirect("/TP_INTEGRADOR_GRUPO_5/Login.jsp");
				
				} else if(currentUser == null){
						System.out.println("No hay usuario");
						response.sendRedirect("/TP_INTEGRADOR_GRUPO_5/Login.jsp");
						
				} else if(session.getAttribute("permiso").equals("NoAdmin"))
				//System.out.println("Que tengo en Transferencia ln.29= "+loginUser.getNombreUsuario());
					
				{
					ClienteNegocio clienteNegocio = new ClienteNegocioImpl();
					String Usuario = currentUser.getNombreUsuario();
					//System.out.println("Usuario ln 31= "+Usuario);
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
							<td style="width: 139px; ">	<h4>TITULAR:</h4></td>
							</tr>
							<TR>
							<td style="width: 139px; "><h4> Nombre y Apellido </h4></td>
							<td style="height: 0px; "><input type="text" name="txtNOMBRE"  value="<%= cl.getNombre() %>" readonly 
							class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
							<td style="height: 0px; "><input type="text" name="txtAPELLIDO"  value="<%= cl.getApellido() %>" readonly 
							class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
							<td style="width: 139px; "><h4> Dni.</h4></td>
							<td style="height: 0px; "><input type="text" name="txtDNI"  value="<%=cl.getDni() %>" readonly 
							class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>
							</TR>
							<tr>
							<td style="width: 139px; "><h4>Cuentas:</h4></td> 
							</tr>
							<tr>
							<td style="width: 139px; "><h4>Cuentas Origen</h4></td> 
							<td style="height: 0px; ">
							<select name="txtCuenta" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" required="required">
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
							<td style="width: 139px; "><h4>Cuentas Destino</h4></td>
							<tr>
							<td style="width: 139px; "><h4>C.B.U.:</h4></td>
							<td style="height: 0px; "><input type="text" name="txtCbuDestino" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" required="required"/></td>
							<td><h4>Importe a Transferir: </h4> </td>
								<td style="height: 0px; ">  <input type="number" name="textImporteTransferencia" required 
								class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/></td>	
							<tr>
							<td style="width: 139px; "><h4>Detalle:</h4></td>
							<td style="height: 0px; "><input type="text" name="txtDetalle" 
							class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" required="required"/></td>
							
							<tr>
							<td style="height: 0px; "><input type="submit" name="btnTranferencia" value="Confirmar"
							class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"
							onclick="return confirm('Confirme Transferencia')"/></td>
						</tr>
					
					</table>
					</form>
					
				
				
				
				
				
				<%} 
				
				%>
				









</body>
</html>