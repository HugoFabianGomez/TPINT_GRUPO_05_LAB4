package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.ReportesNegocio;
import negocioImpl.ReportesNegocioImpl;


@WebServlet("/ServletReportes")
public class ServletReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ReportesNegocio repNeg = new ReportesNegocioImpl();
 
    public ServletReportes() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("reporte1")!=null) {
			int cantidad = repNeg.cantidadClientes();
			request.setAttribute("cantidad", cantidad);
			RequestDispatcher rd = request.getRequestDispatcher("/Reportes.jsp");   
	        rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
