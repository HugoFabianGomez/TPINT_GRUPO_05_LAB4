package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImpl.UsuarioDaoImpl;
import entidades.Usuario;
import negocio.UsuarioNegocio;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDaoImpl usuaNeg = new UsuarioDaoImpl(); 
       
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
		
		UsuarioDaoImpl udao= new UsuarioDaoImpl();
		Usuario Ousuario = null;	
		
		if(request.getParameter("btnIngresar")!=null)
		{
		String userid = request.getParameter("txtusuario");
		String password = request.getParameter("txtclave");
		if(userid!=null || password!=null )
		{

		
		
		
		HttpSession session= request.getSession();
		
		String Result = udao.Login2(userid,password);
			//Boolean Admin = udao.ValidarPermiso(userid,password);
		System.out.println("Devolvio  : " + Result);
		
			if(Result!="Fallo")
			{
				session.setAttribute("userid", userid);
				if(Result.equals("Administrador"))
				{
					System.out.println("ADMIN");
					session.setAttribute("permiso", "Admin");
					response.sendRedirect("Menu.jsp");
				}
				else
				{
					System.out.println("NO ADMIN");
					session.setAttribute("permiso", "NoAdmin");
					response.sendRedirect("Menu.jsp");
				}
				
								

			}
			else
			{
				request.setAttribute("status", "fallo");
				//response.sendRedirect("Login.jsp");
				System.out.println("Error de Usuario o Clave");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			
			}
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
