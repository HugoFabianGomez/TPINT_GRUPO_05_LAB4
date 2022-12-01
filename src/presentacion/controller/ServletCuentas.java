package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.TipoCuenta;
import entidades.TipoMovimiento;
import negocio.ClienteNegocio;
import negocio.CuentaNegocio;
import negocio.MovimientoNegocio;
import negocio.UsuarioNegocio;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;

@WebServlet("/ServletCuentas")
public class ServletCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CuentaNegocio cuNeg = new CuentaNegocioImpl();
	ClienteNegocio cliNeg = new ClienteNegocioImpl();
	UsuarioNegocio userNeg = new UsuarioNegocioImpl();
	MovimientoNegocio movNeg = new MovimientoNegocioImpl();

	public ServletCuentas() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("listar") != null) {

			HttpSession session = request.getSession();
			String tipoUsuario = (String) (session.getAttribute("permiso"));

			if (tipoUsuario == "Admin") {
				ArrayList<Cuenta> listaCuentas = cuNeg.obtenerTodos();
				request.setAttribute("listaCuentas", listaCuentas);
				RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentas.jsp");
				rd.forward(request, response);
			} else if (tipoUsuario == "NoAdmin") {
				String currentUser = (String) (session.getAttribute("userid"));
				int dni = userNeg.obtenerDniUsuario(currentUser);
				
				ArrayList<Cuenta> listaCuentas = cuNeg.obtenerCuentasCliente(dni);
				request.setAttribute("listaCuentas", listaCuentas);
				RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentas.jsp");
				rd.forward(request, response);
			}
		}

		if (request.getParameter("modificar") != null) {
			int numeroCuenta = Integer.parseInt(request.getParameter("modificar"));
			Cuenta cuenta = cuNeg.obtenerUno(numeroCuenta);
			request.setAttribute("cuenta", cuenta);

			RequestDispatcher rd = request.getRequestDispatcher("ModificarCuenta.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("eliminar") != null) {
			int numeroCuenta = Integer.parseInt(request.getParameter("eliminar"));

			boolean elimino = cuNeg.eliminar(numeroCuenta);
			ArrayList<Cuenta> listaCuentas = cuNeg.obtenerTodos();
			request.setAttribute("elimino", elimino);
			request.setAttribute("listaCuentas", listaCuentas);
			RequestDispatcher rd = request.getRequestDispatcher("ListarCuentas.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("btnAgregar") != null) {

			Cuenta cuenta = new Cuenta();
			cuenta.setNumeroCuenta(Integer.parseInt(request.getParameter("txtNumeroCuenta")));
			cuenta.setCbu(Integer.parseInt(request.getParameter("txtCBU")));
			cuenta.setTipoCuenta(new TipoCuenta(Integer.parseInt(request.getParameter("txtTipoCuenta"))));
			cuenta.setFechaCreacion(request.getParameter("txtFechaCreacion"));
			cuenta.setSaldo(10000);
			cuenta.setCliente(new Cliente(Integer.parseInt(request.getParameter("txtDNI"))));
			cuenta.setEstado(true);

			boolean existeNumero = cuNeg.existeNumero(cuenta.getNumeroCuenta());
			boolean existeCbu = cuNeg.existeCbu(cuenta.getCbu());
			boolean existeDni = cuNeg.existeDniCuenta(cuenta.getCliente().getDni());
			boolean inserto = false;
			if (existeNumero == false && existeCbu == false && existeDni == true) {
				int cantidadCuentas = cuNeg.cantidadCuentas(cuenta.getCliente().getDni());
				if (cantidadCuentas < 3) {
					inserto = cuNeg.insertar(cuenta);
					TipoMovimiento tpMov = new TipoMovimiento();
					tpMov.setCodigo(1);
					Movimiento mov = new Movimiento();
					mov.setFecha(request.getParameter("txtFechaCreacion"));
					mov.setCuenta(cuenta);
					mov.setDetalle("Alta de cuenta");
					mov.setImporte(10000);
					mov.setTipoMovimiento(tpMov);
					movNeg.agregar(mov);
				}
			}
			request.setAttribute("inserto", inserto);
			RequestDispatcher rd = request.getRequestDispatcher("AltaCuenta.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("btnConfirmarModificar") != null) {
			Cuenta cuenta = new Cuenta();

			cuenta.setNumeroCuenta(Integer.parseInt(request.getParameter("txtNumeroCuenta")));
			cuenta.setCbu(Integer.parseInt(request.getParameter("txtCBU")));
			cuenta.setTipoCuenta(new TipoCuenta(Integer.parseInt(request.getParameter("txtTipoCuenta"))));
			cuenta.setFechaCreacion(request.getParameter("txtFechaCreacion"));
			cuenta.setSaldo(Float.parseFloat(request.getParameter("txtSaldo")));
			cuenta.setCliente(new Cliente(Integer.parseInt(request.getParameter("txtDNI"))));
			cuenta.setEstado(Boolean.parseBoolean(request.getParameter("comboEstado")));

			boolean modifico = false;
			boolean existeDni = cuNeg.existeDniCuenta(cuenta.getCliente().getDni());

			if (existeDni == true) {
				/*
				 * int cantidadCuentas = cuNeg.cantidadCuentas(cuenta.getCliente().getDni());
				 * if(cantidadCuentas < 3) {
				 */
				modifico = cuNeg.modificar(cuenta);
				/* } */
			}

			ArrayList<Cuenta> listaCuentas = cuNeg.obtenerTodos();
			request.setAttribute("modifico", modifico);
			request.setAttribute("listaCuentas", listaCuentas);
			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentas.jsp");
			rd.forward(request, response);
		}
	}

}
