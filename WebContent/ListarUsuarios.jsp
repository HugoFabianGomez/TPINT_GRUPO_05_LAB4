<%@page import="negocio.UsuarioNegocio"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Usuario" %>
<%@ page import="negocio.UsuarioNegocio" %>
<%@ page import="negocioImpl.UsuarioNegocioImpl" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- DATATABLES -->
    <!--  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"> -->
    <!-- BOOTSTRAP -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
    <style>
        th,td {
            padding: 0.4rem !important;
        }
        body>div {
            box-shadow: 10px 10px 8px #888888;
            border: 2px solid black;
            border-radius: 15px;
        }
    </style>
    <title>MovGeneral</title>
</head>
<body>
	<%
			if(session.getAttribute("userid")==null || session.getAttribute("permiso")=="NoAdmin")
			{
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			}
		
			UsuarioNegocio usuNegocio = new UsuarioNegocioImpl();
			ArrayList<Usuario> lista_usuarios;
			lista_usuarios = usuNegocio.obtenerTodos();
			
	%>
	
		<!--  -->  
	<h1>Lista de Usuarios Solo para ver al momento de la presentacion</h1>
    <div class="container" style="margin-top: 10px;padding: 5px">
    <table id="tablax" class="table table-striped table-bordered" style="width:100%">
        <thead>
        	<tr>
            <th style="text-align: center">USUARIOS</th>
            <th style="text-align: center">CONTRASEÑA</th>
            <th style="text-align: center">ESTADO</th>
            <th style="text-align: center">TIPO USUARIO</th>
            <th style="text-align: center">Accion</th>
            </tr> 
        </thead>
        <tbody>
        		<%  
					if(lista_usuarios!=null)
					for(Usuario us : lista_usuarios) 
				{%>
            <tr>
            		<td><%= us.getNombreUsuario() %> </td>
					<td><%= us.getContrasenia() %> </td>
					<td><%= us.isEstado()%>	</td>
					<td><%= us.getTipoUsuario().getTipoUsuario() %>	</td>
					<td><a class="btn btn-primary" href="/TP_INTEGRADOR_GRUPO_5/Perfil.jsp?Usuario=<%=us.getNombreUsuario()%>">Modificar Pass</a></td>
            </tr>
            <%  } %>
            
        </tbody>
    </table>
        <div>
			<a class="btn btn-primary" href="Inicio.jsp" >Volver</a>
		</div>
</div>


    <!-- JQUERY -->
    <script src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous">
        </script>
    <!-- DATATABLES -->
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js">
    </script>
    <!-- BOOTSTRAP -->
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js">
    </script>
    <script>
        $(document).ready(function () {
            $('#tablax').DataTable({
                language: {
                    processing: "Tratamiento en curso...",
                    search: "Buscar&nbsp;:",
                    lengthMenu: "Agrupar de _MENU_ items",
                    info: "Mostrando del item _START_ al _END_ de un total de _TOTAL_ items",
                    infoEmpty: "No existen datos.",
                    infoFiltered: "(filtrado de _MAX_ elementos en total)",
                    infoPostFix: "",
                    loadingRecords: "Cargando...",
                    zeroRecords: "No se encontraron datos con tu busqueda",
                    emptyTable: "No hay datos disponibles en la tabla.",
                    paginate: {
                        first: "Primero",
                        previous: "Anterior",
                        next: "Siguiente",
                        last: "Ultimo"
                    },
                    aria: {
                        sortAscending: ": active para ordenar la columna en orden ascendente",
                        sortDescending: ": active para ordenar la columna en orden descendente"
                    }
                },
                scrollY: 400,
                lengthMenu: [ [5, 10, -1], [5, 10, "All"] ],
            });
        });
    </script>

</body>
</html>