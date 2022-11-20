<%@page import="entidades.Usuario"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 	<style type="text/css">
		<%@include file="Style.css"%>

	</style>
	<title>Soy la pagina de inicio</title>
</head>

<body>
	<% 
		Usuario currentUser = (Usuario)(session.getAttribute("usuario"));
		if(currentUser==null){
			response.sendRedirect("/TP_INTEGRADOR_GRUPO_5/Login2.jsp");
			//System.out.println("No hay usuario");
		} else {%>
  	<header class="card shadows">
  		<p></p>
	 	<h1>Bienvenido <%=currentUser.getNombreUsuario()%></h1>
	 	<form action="/TP_INTEGRADOR_GRUPO_5/ServletLogin" method="POST">
			<button type="submit" name="cerrarSesion" class="common-button danger">Cerrar Sesion</button>
		</form>
	 	
	 </header>
	 
	 
	 <section id="inicio" class="row">	 
		<div class="col card shadows">
			<div class="row-center ">
				<% 
				if(currentUser.getNombreUsuario() == "lemos.h")
				{%>
					
				
				
				<%} else
				{ %>
				
				<%} %>
			</div>
		</div>
	 </section>
</body>
<%  } %>
	 	
	 	
	 


	<jsp:include page="Menu.html"></jsp:include>
	<h1>Soy la página de inicio</h1>
</body>
</html>