package presentacion.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import entidades.Cliente;
import entidades.Nacionalidad;
import entidades.Provincia;
import entidades.Usuario;
import negocio.ClienteNegocio;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;
import entidades.Genero;
import entidades.Localidad;
import CreandoException.ValidoDniUsuario;


@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ClienteNegocio ClienteNeg = new ClienteNegocioImpl();
	static UsuarioNegocioImpl UsuaNeg = new UsuarioNegocioImpl();
	
	

	public ServletClientes() {
		super();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar")!=null)
		{
			boolean filas = false;
			System.out.println("Entro Servlet Cliente ln 46");
			
			
				Usuario usu = new Usuario();
				usu.setNombreUsuario(request.getParameter("textUSUARIO"));
				usu.setContrasenia(request.getParameter("txtDNI"));
				filas= UsuaNeg.agregar(usu);
				
				
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
								
				try {
					filas=ClienteNeg.agregar(cliente);
					System.out.println("Valor de filas= "+filas);
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("se ha violado una restricción de integridad (clave externa, clave principal o clave única)");
					JOptionPane.showMessageDialog(null, "se ha violado una restricción de integridad (clave externa, clave principal o clave única)"+ e.getStackTrace());
					RequestDispatcher rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
				}
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

			boolean filas = ClienteNeg.modificar(cl);
			
			request.setAttribute("filas", filas);
			request.setAttribute("dni", dni);
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarCliente.jsp");   
	        rd.forward(request, response);  
			
		} else if(request.getParameter("btnEliminar")!=null) {
			boolean Dni = false;
			int dni =Integer.parseInt(request.getParameter("Dni"));
			System.out.println("Enmtre a eliminar dni ="+dni);
			Dni =ClienteNeg.borrar(Integer.parseInt(request.getParameter("Dni")));
			
			
			request.setAttribute("eliminado", true);
			request.setAttribute("filasEliminado", Dni);
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");   
	        rd.forward(request, response);
			
		} 
		
		
	}
	public static ArrayList<Cliente> obtenerClientes() {
		return ClienteNeg.obtenerTodos();
	}
	
	public static ArrayList<Cliente> obtenerClientes(String dni) {
		System.out.println("Servlet");
		return ClienteNeg.obtenerTodos(Integer.parseInt(dni));
	}
	
	public static Cliente obtenerCliente(String dni) {
		return ClienteNeg.obtenerUno(Integer.parseInt(dni));
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
			System.out.println("cuil= "+cl.getCuil());
			cl.setNombre(request.getParameter("txtNOMBRE"));
			System.out.println("nombre= "+cl.getNombre());
			cl.setApellido(request.getParameter("txtAPELLIDO"));
			System.out.println("apellido= "+cl.getApellido());
			cl.setNacionalidad(new Nacionalidad(Integer.parseInt(request.getParameter("txtNACIONALIDAD"))));
			System.out.println("nacionalidad= "+cl.getNacionalidad().getCodigo());
			cl.setFechaNacimiento(request.getParameter("txtFECHA_NAC"));
			System.out.println("fecha= "+cl.getFechaNacimiento());
			cl.setGenero(new Genero(Integer.parseInt(request.getParameter("txtSEXO"))));
			System.out.println("genero= "+cl.getGenero().getCodigo());
			cl.setDomicilio(request.getParameter("txtDIRECCION"));
			System.out.println("direccion= "+cl.getDomicilio());
			cl.setLocalidad(new Localidad(Integer.parseInt(request.getParameter("txtLOCALIDAD"))));
			System.out.println("localidad= "+cl.getLocalidad().getCodigo());
			cl.setProvincia(new Provincia(Integer.parseInt(request.getParameter("txtPROVINCIA"))));
			System.out.println("provincia= "+cl.getProvincia().getCodigo());
			cl.setEmail(request.getParameter("textEMAIL"));
			System.out.println("email= "+cl.getEmail());
			cl.setTelefono(request.getParameter("txtTELEFONO"));
			System.out.println("telefono= "+cl.getTelefono());

			boolean filas = ClienteNeg.modificar(cl);
			
			request.setAttribute("filas", filas);
			request.setAttribute("dni", dni);
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");
	        rd.forward(request, response);  
			
		}
	}


}
