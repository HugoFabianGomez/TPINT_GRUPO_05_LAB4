package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.ClienteDaoImpl;
import entidades.Cliente;

@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletClientes() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lista clientes
		ClienteDaoImpl cliDao = new ClienteDaoImpl();
		ArrayList<Cliente> listaClientes = cliDao.obtenerTodos();
		request.setAttribute("listaClientes", listaClientes);
		RequestDispatcher rd = request.getRequestDispatcher("/AutorizarPrestamo.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
