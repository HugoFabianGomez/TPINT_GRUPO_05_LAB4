package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import entidades.Usuario;
import negocio.UsuarioNegocio;
import negocioImpl.UsuarioNegocioImpl;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioNegocio usuaNeg = new UsuarioNegocioImpl(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		if(request.getParameter("btnIngresar")!=null)
		{
			Usuario usuario = usuaNeg.login(request.getParameter("txtusuario"), request.getParameter("txtclave"));
			
			if(usuario != null) {
				System.out.println("Usuario logueado: "+usuario.getNombreUsuario());
				
				session.setAttribute("usuario", usuario);
				RequestDispatcher rd = request.getRequestDispatcher("/Inicio.jsp");   
		        rd.forward(request, response);    
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/Login2.jsp");
				request.setAttribute("noEncontrado", true);
		        rd.forward(request, response);
			}
					
		
		} else if (request.getParameter("cerrarSesion")!= null) {
			session.removeAttribute("usuario");
			System.out.println("cerrarSesion");
			RequestDispatcher rd = request.getRequestDispatcher("/Login2.jsp");   
	        rd.forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
