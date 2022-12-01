<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.TipoCuenta"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Agregar Cuenta</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	
	<jsp:include page="Menu.jsp"></jsp:include>
<h2 style="text-align: center; margin-bottom: 20px;">Alta de Cuenta</h2>

<form action="ServletCuentas" method="post">
	
	<% 
	
		ArrayList<TipoCuenta> listaTipos = new ArrayList<TipoCuenta>();
		if(request.getAttribute("listaTipos")!=null){
			listaTipos = (ArrayList<TipoCuenta>)request.getAttribute("listaTipos");
		}
	
	%>

<div class="row"
			style="margin: auto; width: 60%; border: 3px solid #73AD21; padding: 10px">
			<div class="col-md-6">
				<div class="mb-3">
					<div class="mb-3">
					<label for="txtNumeroCuenta" class="form-label">Numero de cuenta: </label> <input type="Number" name="txtNumeroCuenta"
					required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
					placeholder="0000000000"/>
					</div>
				</div>

				<div class="mb-3">
					<label id="txtDNI" class="form-label">DNI del cliente:</label> <input type="Number" name="txtDNI" min="1" max="99999999"
					required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))" 
					placeholder="00000000"/>
				</div>

				<div class="mb-3">
					<label for="txtTipoCuenta" class="form-label">Tipo de cuenta</label> <select
						required="required" name="txtTipoCuenta" class="form-select">
						<%
						for(TipoCuenta tpCue : listaTipos){					
				 		%>								 		
						<option value="<%=tpCue.getCodigo()%>"><%=tpCue.getDescripcion() %></option>		
				 		<% 
						}
						 %>		
					</select>

				</div>

				<div class="mb-3">
					<button type="submit" name="btnAgregar" onclick="return confirm('¿Está seguro que desea agregar esta cuenta?')" value="Agregar" class="btn btn-success">Agregar</button>
				</div>
				
			<% 
			boolean inserto=false;
			if(request.getAttribute("inserto")!=null){
				inserto = (Boolean)request.getAttribute("inserto");
				if(inserto==false){
				%>
					<div class="mb-3">
						<label class="form-label">Error al insertar cuenta..</label>
					</div>
				<% 
				}
				else if(inserto==true){
				%>
					<div class="mb-3">
						<label class="form-label">Cuenta agregada con éxito!</label>
					</div>
				
				<% 
				}
			}
			%>
				
			</div>

			<div class="col-md-6">

				<div>
					<div class="mb-3">
					<label for="txtCBU" class="form-label">CBU: </label> <input type="Number" name="txtCBU" 
					required  maxlength="22" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
					placeholder="0000000000000000000000" />
					</div>
				</div>

				<div class="mb-3">
					<label for="txtFechaCreacion" class="form-label">Fecha de creación</label> <input type="date" name="txtFechaCreacion" 
					required autocomplete="off" placeholder="DD/MM/AAAA"/>
				</div>

				<div class="mb-3">
					<label for="txtMonto" class="form-label">Monto Inicial:</label><input type="text" style="align =center;" readonly value="$10000"/>
				</div>
			</div>
		</div>



</form>

</body>
</html>