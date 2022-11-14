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
import entidades.Usuario;
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar")!=null)
		{
			System.out.println("Entro Servlet");
			Cliente cliente =  new Cliente();
			
			cliente.setDni(Integer.parseInt(request.getParameter("txtDNI")));
			cliente.setCuil(Integer.parseInt(request.getParameter("txtCUIL")));
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
			cliente.setUsuario(new Usuario(request.getParameter("textUSUARIO")));
			
			//System.out.println(cliente.getFechaNacimiento());
			
			Boolean filas=ClienteNeg.agregar(cliente);
			//REQUESTDISPATCHER
			request.setAttribute("filas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");   
	        rd.forward(request, response);
	        
		} else if(request.getParameter("btnModificar")!=null) 
		{
			Cliente cl=  new Cliente();
			int dni = Integer.parseInt(request.getParameter("dni"));
			
			cl.setDni(dni);
			System.out.println("dni= "+dni);
			cl.setCuil(Integer.parseInt(request.getParameter("txtCUIL")));
			cl.setNombre(request.getParameter("txtNOMBRE"));
			cl.setApellido(request.getParameter("txtAPELLIDO"));
			cl.setNacionalidad(new Nacionalidad(Integer.parseInt(request.getParameter("txtNACIONALIDAD"))));
			cl.setFechaNacimiento(request.getParameter("txtFECHA_NAC"));
			cl.setGenero(new Genero(Integer.parseInt(request.getParameter("txtSEXO"))));
			cl.setDomicilio(request.getParameter("txtDIRECCION"));
			cl.setLocalidad(new Localidad(Integer.parseInt(request.getParameter("txtLOCALIDAD"))));
			cl.setProvincia(new Provincia(Integer.parseInt(request.getParameter("txtPROVINCIA"))));
			cl.setEmail(request.getParameter("textEMAIL"));
			cl.setTelefono(request.getParameter("txtTELEFONO"));

			int filas = ClienteNeg.modificar(cl);
			
			request.setAttribute("filas", filas);
			request.setAttribute("dni", dni);
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarCliente.jsp");   
	        rd.forward(request, response);  
			
		}
		
		
	}
	public static ArrayList<Cliente> obtenerClientes() {
		return ClienteNeg.obtenerTodos();
	}
	
	public static Cliente obtenerCliente(int dni) {
		return ClienteNeg.obtenerUno(dni);
	}

		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("btnModificar")!=null) 
		{
			Cliente cl=  new Cliente();
			int dni = Integer.parseInt(request.getParameter("txtDNI"));
			
			cl.setDni(dni);
			System.out.println("dni= "+dni);
			cl.setCuil(Integer.parseInt(request.getParameter("txtCUIL")));
			cl.setNombre(request.getParameter("txtNOMBRE"));
			cl.setApellido(request.getParameter("txtAPELLIDO"));
			cl.setNacionalidad(new Nacionalidad(Integer.parseInt(request.getParameter("txtNACIONALIDAD"))));
			cl.setFechaNacimiento(request.getParameter("txtFECHA_NAC"));
			cl.setGenero(new Genero(Integer.parseInt(request.getParameter("txtSEXO"))));
			cl.setDomicilio(request.getParameter("txtDIRECCION"));
			cl.setLocalidad(new Localidad(Integer.parseInt(request.getParameter("txtLOCALIDAD"))));
			cl.setProvincia(new Provincia(Integer.parseInt(request.getParameter("txtPROVINCIA"))));
			cl.setEmail(request.getParameter("textEMAIL"));
			cl.setTelefono(request.getParameter("txtTELEFONO"));

			int filas = ClienteNeg.modificar(cl);
			
			request.setAttribute("filas", filas);
			request.setAttribute("dni", dni);
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarCliente.jsp");   
	        rd.forward(request, response);  
			
		}
	}

	//protected void doPost(HttpServletRequest request, HttpServletResponse response)
	//		throws ServletException, IOException {
	//}
}
