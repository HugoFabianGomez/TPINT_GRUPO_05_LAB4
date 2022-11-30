 <%@page import="javax.swing.JOptionPane" %>
<%@page import="negocio.ClienteNegocio"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Cliente" %>
<%@ page import="negocio.ClienteNegocio" %>
<%@ page import="negocioImpl.ClienteNegocioImpl" %>
<%@ page import="presentacion.controller.ServletClientes" %>

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
			if(session.getAttribute("filas") !=null){
					boolean filas = Boolean.parseBoolean(request.getParameter("filas"));
					if(filas == true){
						out.println("El registro se agrego correctamente");
						 JOptionPane.showMessageDialog(null, "El registro se agrego correctamente");
					}
			}
			ArrayList<Cliente> lista_cliente = (ArrayList<Cliente>) ServletClientes.obtenerClientes();
	%>
	
		<!--  -->  
	<h1>Lista de Clientes</h1>
    <div class="container" style="margin-top: 10px;padding: 5px">
    <table id="tablax" class="table table-striped table-bordered" style="width:100%">
        <thead>
        	<tr>
            <th style="text-align: center">DNI</th>
            <th style="text-align: center">CUIL</th>
            <th style="text-align: center">Nombre</th>
            <th style="text-align: center">Apellido</th>
            <th style="text-align: center">Email</th>
            <th style="text-align: center">Telefono</th>
            <th style="text-align: center">Fecha_Nacim</th>
            <th style="text-align: center">Estado</th>
            <th  style="text-align: center">Ejecutar</th>
            <th></th>
            </tr> 
        </thead>
        <tbody>
        		<%  
					if(lista_cliente!=null)
					for(Cliente cl : lista_cliente) 
				{%>
            <tr>
            		<td><%= cl.getDni() %></td>
					<td><%= cl.getCuil() %>		</td>
					<td><%= cl.getNombre() %>		</td>
					<td><%= cl.getApellido() %>		</td>
					<td><%= cl.getEmail() %>		</td>
					<td><%= cl.getTelefono() %>		</td>
					<td ><%= cl.getFechaNacimiento() %>		</td>
					<td><%= cl.getEstado() %>		</td>
					
					<td><a class="btn btn-primary" href="/TP_INTEGRADOR_GRUPO_5/ModificarCliente.jsp?dni=<%=cl.getDni()%>">Modificar</a></td>
					<form method= "post" action="ServletClientes?Dni=<%=cl.getDni()%>">
					<td><input type="submit" name="btnEliminar" value="Eliminar" class="btn btn-danger"
					onclick="return confirm('Aceptar Confirmara eliminar el Acliente')" /></td>
					</form>
                
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
                lengthMenu: [ [6, 10, -1], [6, 10, "All"] ],
            });
        });
    </script>

</body>
</html>