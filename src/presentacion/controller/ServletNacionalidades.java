package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidades.Nacionalidad;
//import negocio.ClienteNegocio;
import negocio.NacionalidadNegocio;
//import negocioImpl.ClienteNegocioImpl;
import negocioImpl.NacionalidadNegocioImpl;

/**
 * Servlet implementation class servletNacionalidades
 */
@WebServlet("/servletNacionalidades")
public class ServletNacionalidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static NacionalidadNegocio NacNegocio = new NacionalidadNegocioImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNacionalidades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static ArrayList<Nacionalidad> obtenerNacionalidades() {
		return NacNegocio.obtenerTodos();
	}
	
	
}
