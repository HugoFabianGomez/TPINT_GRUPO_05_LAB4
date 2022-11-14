package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Localidad;
import negocio.LocalidadNegocio;
import negocioImpl.LocalidadNegocioImpl;

@WebServlet("/ServletLocalidades")
public class ServletLocalidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static LocalidadNegocio LocNegocio = new LocalidadNegocioImpl();
    
    public ServletLocalidades() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public static ArrayList<Localidad> obtenerLocalidades() {
		return LocNegocio.obtenerLocalidad();
	}
	

}
