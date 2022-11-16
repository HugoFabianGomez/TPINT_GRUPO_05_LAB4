<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="presentacion.controller.ServletClientes"%>
    <%@page import="javax.servlet.http.HttpSession"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<%		
	
		String user = session.getAttribute("userid").toString();

 		
	%>

<div class="container">
            <form class="user">

                <div class="col-9 row justify-content-center">
                    <div class="align-items-center col-auto">
                        <fieldset>
                            <legend>
                                <i class="fa fa-database">Cambio de clave</i>
                            </legend>



                            <div class="form-group row" runat="server">
                            <div class="col-sm-7 mb-3 mb-sm-3">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" required="required" id="LblApellido" value="<%=user %>" readonly runat="server">
                                <label for="floatingInput">Usuario:</label>
                                </div>
                            </div>
                            <div class="col-sm-7 mb-3 mb-sm-3">
                                <div class="form-floating mb-4">
									<input type="password" class="form-control" required="required" id="LblApellido" value="Clave"  runat="server">
                                    <label for="floatingInput">Contraseña</label>
                                </div>
                                </div>
                            </div>
						
                            </fieldset>
                                     <td class="common-button secondary"><input type="submit" name="btnModificar" value="MODIFICAR"/></td>
                                     	</div>
                    </div>
                    		
</div>

</form>
</div>
</body>
</html>