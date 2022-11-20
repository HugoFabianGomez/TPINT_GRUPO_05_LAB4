<%@page import="daoImpl.UsuarioDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
		<%
			session.removeAttribute("userid");
		%>

<div class="container">
        <form id="Formulario_Login" action="ServletLogin" method="get" lang="es">
     
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div>
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image" alt="Alps">
                                <img src="https://img.freepik.com/vector-premium/edificio-banco-retro-dibujos-animados-o-palacio-justicia-columnas-ilustracion-aislado-blanco_166005-61.jpg?w=2000" style="width:500px">

                            </div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Banco, Bienvenido!</h1>
                                    </div>
                                    <form class="user">
                                    
                             
										  
										  
										 <div class="form-floating mb-3">
											  <input class="form-control" name="txtusuario" required="true" placeholder="Userid">
											  <label for="floatingInput">Usuario</label>
											</div>
											<div class="form-floating">
											  <input type="password" class="form-control" name="txtclave" required="true" placeholder="Password">
											  <label for="floatingPassword">Clave</label>
											</div>
										 
										  <label for="floatingPassword" id="txterror"></label>
										  
										  <%
										  if (request.getAttribute("status")=="fallo"){										  
										  
										  %>
										  <div class="alert alert-danger" role="alert">
										 Usuario o Clave incorrectas
										</div>										 
										  <%
										  }%>
										  
										<div class="text-center">

											  <button class="btn btn-primary" name="btnIngresar" type="submit">Ingresar</button>
											  
										</div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
           </form>
    </div>

</body>