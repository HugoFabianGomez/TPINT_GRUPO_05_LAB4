package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Provincia;
import negocio.ProvinciaNegocio;
import negocioImpl.ProvinciaNegocioImpl;


@WebServlet("/ServletProvincias")
public class ServletProvincias extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProvinciaNegocio ProvNegocio = new ProvinciaNegocioImpl();
       
    public ServletProvincias() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public static ArrayList<Provincia> obtenerProvincia(){
		return ProvNegocio.obtenerTodos();
	}

}
