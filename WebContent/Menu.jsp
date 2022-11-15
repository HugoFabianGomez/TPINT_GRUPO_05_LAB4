<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<link href="css/Style.css" rel="stylesheet">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("userid")==null)
	{
	
		
		response.sendRedirect("Login.jsp");
		
			}

%>


<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Nuestro Banco</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		<% if(session.getAttribute("permiso").equals("Admin"))
           { %>
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Clientes
		          </a>
		          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		            <li><a class="dropdown-item" href="AltaCliente.jsp">Alta</a></li>
		            <li><a class="dropdown-item" href="ListarClientes.jsp">Listar</a></li>
		          </ul>
		        </li>
        
                <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Usuarios
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="AltaUsuario.jsp">Alta</a></li>
            <li><a class="dropdown-item" href="ListarUsuarios.jsp">Listar</a></li>
          </ul>
        </li>
                <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Cuentas
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="AltaCuenta.jsp">Nuevo</a></li>
            <li><a class="dropdown-item" href="ListarCuentas.jsp">Listar</a></li>
          </ul>
        </li>
<%} %>
                <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Movimientos
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="Transferencia.jsp">Nuevo</a></li>
            <li><a class="dropdown-item" href="ListarMovimientos.jsp">Listar</a></li>
          </ul>
        </li>
     
      
     <!--PRESTAMOS-->
       <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Prestamos
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
          		<% if(session.getAttribute("permiso").equals("Admin"))
           { %>
            <li><a class="dropdown-item" href="AutorizarPrestamo">Autorizar</a></li>
            <%} %>
            <li><a class="dropdown-item" href="PagosPrestamos.jsp">Pagar</a></li>
            <li><a class="dropdown-item" href="Prestamos.jsp">Listar</a></li>
          </ul>
        </li>
      </ul>

      
	   <!--   <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form> --> 
      
      

        
    </div>
      
<img class="img-profile rounded-circle" width="50" height="60" src="Img/undraw_profile.svg">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                      <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
           <% if(session.getAttribute("userid")!=null)
           { %>
           
           <%=session.getAttribute("userid").toString() %>
           
           <%} %>
          </a>
          
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="Test.jsp">Perfil</a></li>
              <li><a class="dropdown-item" data-toggle="modal" data-target="#myModal">Salir</a></li>  
            
            
          </ul>
        </li>
        </ul>
                      
    
  </div>
</nav>



<!-- Modal -->  
  <div class="modal fade" id="myModal" role="dialog">  
    <div class="modal-dialog">  
      
      <!-- Modal content-->  
      <div class="modal-content">  
        <div class="modal-header">  
          <button type="button" class="close" data-dismiss="modal">×</button>  
 				<h5 class="modal-title" id="exampleModalLabel">Listo para salir</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">¿Estas seguro de querer cerrar sesion?</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="Login.jsp">Logout</a>
        </div>  
      </div>  
        
    </div>  
  </div>       
                  

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  

</body>
</html>