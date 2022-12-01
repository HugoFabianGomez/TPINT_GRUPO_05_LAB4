<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entidades.Cuenta" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="Menu.jsp"></jsp:include>
<h2 style="text-align: center; margin-bottom: 20px;">Modificar Cuenta</h2>



<%
	Cuenta cuenta = new Cuenta();
	if(request.getAttribute("cuenta")!=null){
		cuenta = (Cuenta)request.getAttribute("cuenta"); 
	}

%>
<form action="ServletCuentas" method="post">


<div class="row" style="margin: auto; width: 60%; border: 3px solid #73AD21; padding: 10px">
			<div class="col-md-6">
				<div class="mb-3">
					<div class="mb-3">
					<label for="txtNumeroCuenta" class="form-label">Numero de cuenta: </label> <input type="Number" name="txtNumeroCuenta"
					readonly value="<%=cuenta.getNumeroCuenta() %>"/>
					</div>
				</div>

				<div class="mb-3">
					<label id="txtDNI" class="form-label">DNI del cliente:</label> <input type="Number" name="txtDNI" min="1" max="99999999"
					required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))" 
					placeholder="00000000" value="<%=cuenta.getCliente().getDni() %>"/>
				</div>

				<div class="mb-3">
					<label for="txtTipoCuenta" class="form-label">Tipo de cuenta</label> <select
						required="required" name="txtTipoCuenta" class="form-select">
					<%
					if(cuenta.getTipoCuenta().getCodigo()==1){
					%>
						<option value="1" selected>Caja de Ahorro</option>
						<option value="2" >Cuenta Corriente</option>
					<%
					}
					else{ 
					%>
						<option value="1" >Caja de Ahorro</option>
						<option value="2" selected>Cuenta Corriente</option>
					<%
					}
				 	%>	
					</select>
				</div>
				
					<div class="mb-3">
					<label for="txtSaldo" class="form-label">Saldo</label> <input
						type="text" class="form-control" id="txtSaldo" name="txtSaldo"
						required maxlength="40" autocomplete="off" onchange="update();"
						required="required"
						oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" value="<%=cuenta.getSaldo()%>"/>
					</div>
					<!-- DESARROLLO OPCIONES TIPO DE CUENTA -->									 				

				<div class="mb-3">										
					<button type="submit" name="btnConfirmarModificar" onclick="return confirm('¿Está seguro que desea modificar esta cuenta?')" value="Modificar" class="btn btn-success">Modificar</button>
				</div>
				
				
				
			</div>

			<div class="col-md-6">

				<div class="mb-3">
					<label for="txtCBU" class="form-label">CBU: </label> <input type="Number" name="txtCBU" 
					readonly value="<%=cuenta.getCbu() %>"/>
				</div>

				<div class="mb-3">
					<label for="txtFechaCreacion" class="form-label">Fecha de creación</label> <input type="date" readonly="readonly" 
					name="txtFechaCreacion" value="<%=cuenta.getFechaCreacion() %>"/>
				</div>
			
				<div class="mb-3">
					<label for="comboEstado" class="form-label">Estado</label>
					<select	required="required" name="comboEstado" class="form-select">
						<%
						if(cuenta.getEstado()==true){
						%>
							<option value=true selected> Activa </option>
							<option value=false> Inactiva </option>
						<% 
						}
						else{
						 %>
							<option value=true> Activa </option>
							<option value=false selected> Inactiva </option>
						<%
						}
						 %>
					</select>
				</div>
			</div>
		</div>



</form>
	

</body>
</html>
