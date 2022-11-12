package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.Nacionalidad;
import entidades.Provincia;
import negocio.ClienteNegocio;
import negocioImpl.ClienteNegocioImpl;
import entidades.Genero;
import entidades.Localidad;

import daoImpl.ClienteDaoImpl;
import entidades.Cliente;
//>>>>>>> 5b4a8aa43b3a66077f920fb03041551279e015b3

@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ClienteNegocio ClienteNeg = new ClienteNegocioImpl();

	public ServletClientes() {
		super();
	}

//<<<<<<< HEAD
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar")!=null)
		{
			Cliente cliente =  new Cliente();
			
			cliente.setDni(Integer.parseInt(request.getParameter("txtDNI")));
			cliente.setDni(Integer.parseInt(request.getParameter("txtCUIL")));
			cliente.setNombre(request.getParameter("txtNOMBRE"));
			cliente.setApellido(request.getParameter("txtAPELLIDO"));
			cliente.setNacionalidad(new Nacionalidad(Integer.parseInt(request.getParameter("txtNACIONALIDAD"))));
			cliente.setFechaNacimiento(request.getParameter("txtFECHA_NAC"));
			cliente.setGenero(new Genero(Integer.parseInt(request.getParameter("txtGENERO"))));
			cliente.setDomicilio(request.getParameter("txtDIRECCION"));
			cliente.setLocalidad(new Localidad(Integer.parseInt(request.getParameter("txtLOCALIDAD"))));
			cliente.setProvincia(new Provincia(Integer.parseInt(request.getParameter("txtPROVINCIA"))));
			cliente.setEmail(request.getParameter("textEMAIL"));
			cliente.setTelefono(request.getParameter("txtTELEFONO"));
			
	
			
			System.out.println(cliente.getFechaNacimiento());
			
			Boolean filas=ClienteNeg.agregar(cliente);
			//REQUESTDISPATCHER
			request.setAttribute("filas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/AltaCliente.jsp");   
	        rd.forward(request, response);
		}
	}

		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lista clientes
		ClienteDaoImpl cliDao = new ClienteDaoImpl();
		ArrayList<Cliente> listaClientes = cliDao.obtenerTodos();
		request.setAttribute("listaClientes", listaClientes);
		RequestDispatcher rd = request.getRequestDispatcher("/AutorizarPrestamo.jsp");
		rd.forward(request, response);
//>>>>>>> 5b4a8aa43b3a66077f920fb03041551279e015b3
	}

	//protected void doPost(HttpServletRequest request, HttpServletResponse response)
	//		throws ServletException, IOException {
	//}
}
