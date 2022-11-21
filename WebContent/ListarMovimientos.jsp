<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Cuenta" %>
<%@ page import="negocio.CuentaNegocio" %>
<%@ page import="negocioImpl.CuentaNegocioImpl" %>

<%@ page import="entidades.Movimiento" %>
<%@ page import="negocio.MovimientoNegocio" %>
<%@ page import="negocioImpl.MovimientoNegocioImpl" %>

<%@ page import="presentacion.controller.ServletCuentas" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista de Movimientos</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<h1>Lista de Movimientos</h1>
		<%
			MovimientoNegocio mtoNegocio = new MovimientoNegocioImpl();
			ArrayList<Movimiento> lista_movimiento;
	
	
			String DniaBuscar = request.getParameter("buscarDni"); 
			if(DniaBuscar != null && DniaBuscar !=""){
				lista_movimiento = mtoNegocio.obtenerTodos();
			}else{
				lista_movimiento = mtoNegocio.obtenerTodos();
		
			}
	%>


<form method="get" action="ServletListaMovimientos">
	 <table>
	 	<tr>
	 		<td>Filtrar Movimientos</td>
	 		<td><select name="">
		<option value="" >Todos</option>
		<!-- ACA  SE DESARROLLARA SEGUN EL FULTRO QUE PIDA LA PROFESORA -->
	</select></td>
	 	</tr>
	 	<tr>
	 		<td align="right">Búsqueda de Movimiento</td>
	 		<td style="height: 0px;"><input type="text" name="txtBusqueda"/></td>
	 	</tr>
	 </table>
	
	<br><br>	
	
	<table border="1" width="900">
		<thead>
			<tr>
				<th style="width: 200px; ">Código_Mov</th>
				<th style="width: 200px; ">Fecha</th>
				<th style="width: 200px; ">Detalle</th>
				<th style="width: 200px; ">Tipo_Movimiento</th>
				<th style="width: 200px; ">Importe</th>
				<th style="width: 200px; ">CBU</th>
			</tr>
		</thead>
			<tbody>
				<%
					if(lista_movimiento !=null)
					for(Movimiento mv : lista_movimiento) 
				{%>
				<tr>
					<td><%= mv.getCodigo() %>		</td>
					<td><%= mv.getFecha() %>		</td>
					<td><%= mv.getDetalle() %>		</td>
					<td><%= mv.getTipoMovimiento().getDescripcion() %>		</td>
					<td><%= mv.getImporte() %>		</td>
					<td><%= mv.getCuenta().getCbu() %>		</td>
					<td>		</td>					
				
				</tr>
				<%} %>
			
			</tbody>
		
	</table>
		<div>
			<a class="btn btn-primary" href="Inicio.jsp">Volver</a>
		</div>
	
</form>

</body>
</html>