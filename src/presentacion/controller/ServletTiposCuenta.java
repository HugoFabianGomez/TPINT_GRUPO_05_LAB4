package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.TipoCuenta;
import negocio.TipoCuentaNegocio;
import negocioImpl.TipoCuentaNegocioImpl;

@WebServlet("/ServletTiposCuenta")
public class ServletTiposCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TipoCuentaNegocio clNeg = new TipoCuentaNegocioImpl();  
	
    public ServletTiposCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("param")!=null) {
			System.out.println("SERVLET CUENTAS");
			ArrayList<TipoCuenta> listaTipos = clNeg.obtenerTodos(); 
			request.setAttribute("listaTipos", listaTipos);
			RequestDispatcher rd = request.getRequestDispatcher("AltaCuenta.jsp");   
	        rd.forward(request, response);			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
