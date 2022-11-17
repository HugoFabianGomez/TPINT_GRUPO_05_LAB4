package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.TipoCuenta;
import negocio.CuentaNegocio;
import negocioImpl.CuentaNegocioImpl;


@WebServlet("/ServletCuentas")
public class ServletCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CuentaNegocio cuNeg = new CuentaNegocioImpl();

    public ServletCuentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("listar")!=null) {
			ArrayList<Cuenta> listaCuentas = cuNeg.obtenerTodos();
			request.setAttribute("listaCuentas", listaCuentas);
			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentas.jsp");   
	        rd.forward(request, response);	
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnAgregar")!=null) {
			Cuenta cuenta = new Cuenta();
			
			cuenta.setNumeroCuenta(Integer.parseInt(request.getParameter("txtNumeroCuenta")));
			cuenta.setCbu(Integer.parseInt(request.getParameter("txtCBU")));
			cuenta.setTipoCuenta(new TipoCuenta(Integer.parseInt(request.getParameter("txtTipoCuenta"))));
			cuenta.setFechaCreacion(request.getParameter("txtFechaCreacion"));
			cuenta.setSaldo(10000);
			cuenta.setCliente(new Cliente(Integer.parseInt(request.getParameter("txtDNI"))));
			cuenta.setEstado(true);
			
			boolean filas = cuNeg.insertar(cuenta);
			request.setAttribute("filas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("AltaCuenta.jsp");   
	        rd.forward(request, response) ;
		}
		
		if(request.getParameter("btnModificar")!=null) {
				int numeroCuenta = Integer.parseInt(request.getParameter("numeroCuenta"));			
				Cuenta cuenta = cuNeg.obtenerUno(numeroCuenta);
				request.setAttribute("cuenta", cuenta);
				
				RequestDispatcher rd = request.getRequestDispatcher("ModificarCuenta.jsp");   
		        rd.forward(request, response) ;
		}
		
		else if(request.getParameter("btnConfirmarModificar")!=null) {
			Cuenta cuenta = new Cuenta();
			
			cuenta.setNumeroCuenta(Integer.parseInt(request.getParameter("txtNumeroCuenta")));
			cuenta.setCbu(Integer.parseInt(request.getParameter("txtCBU")));
			cuenta.setTipoCuenta(new TipoCuenta(Integer.parseInt(request.getParameter("txtTipoCuenta"))));
			cuenta.setFechaCreacion(request.getParameter("txtFechaCreacion"));
			cuenta.setSaldo(Float.parseFloat(request.getParameter("txtSaldo")));
			cuenta.setCliente(new Cliente(Integer.parseInt(request.getParameter("txtDNI"))));
			cuenta.setEstado(Boolean.parseBoolean(request.getParameter("comboEstado")));
			System.out.println("ESTADO: "+ Boolean.parseBoolean(request.getParameter("comboEstado")));
			cuNeg.modificar(cuenta);
			ArrayList<Cuenta> listaCuentas = cuNeg.obtenerTodos();
			request.setAttribute("listaCuentas", listaCuentas);
			RequestDispatcher rd = request.getRequestDispatcher("ListarCuentas.jsp");   
	        rd.forward(request, response) ;
		}
		
		else if(request.getParameter("btnEliminar")!=null) {
			int numeroCuenta = Integer.parseInt(request.getParameter("numeroCuenta"));
			cuNeg.eliminar(numeroCuenta);
			ArrayList<Cuenta> listaCuentas = cuNeg.obtenerTodos();
			request.setAttribute("listaCuentas", listaCuentas);
			RequestDispatcher rd = request.getRequestDispatcher("ListarCuentas.jsp");   
	        rd.forward(request, response) ;
		}
		
	}

}
