package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Genero;
import negocio.GeneroNegocio;
import negocioImpl.GeneroNegocioImpl;


@WebServlet("/ServletGeneros")
public class ServletGeneros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static GeneroNegocio GenNegocio = new GeneroNegocioImpl();
    
    public ServletGeneros() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public static ArrayList<Genero> obtenerGeneros() {
		//System.out.println("LLEGUE EN SERVLETGENERO");
		return GenNegocio.obtenerTodos();
	}

}
