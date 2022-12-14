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
import entidades.Cuota;
import entidades.Movimiento;
import entidades.Prestamo;
import entidades.TipoMovimiento;
import negocio.ClienteNegocio;
import negocio.CuentaNegocio;
import negocio.CuotaNegocio;
import negocio.MovimientoNegocio;
import negocio.PrestamoNegocio;
import negocio.UsuarioNegocio;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.CuotaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import negocioImpl.PrestamoNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;

@WebServlet("/ServletPrestamos")
public class ServletPrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ClienteNegocio clNeg = new ClienteNegocioImpl();
	private static CuentaNegocio cuenNeg = new CuentaNegocioImpl();
	private static PrestamoNegocio presNeg = new PrestamoNegocioImpl();
	private static UsuarioNegocio userNeg = new UsuarioNegocioImpl();
	private static CuotaNegocio cuoNeg = new CuotaNegocioImpl();
	private static MovimientoNegocio movNeg = new MovimientoNegocioImpl();

	public ServletPrestamos() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("mp") != null) {
			Cliente cli = new Cliente();
			HttpSession session = request.getSession();
			String currentUser = (String) (session.getAttribute("userid"));

			int dni = userNeg.obtenerDniUsuario(currentUser);
			cli = clNeg.obtenerUno(dni);
			request.setAttribute("labelCliente", cli.getNombreCompleto());
			request.setAttribute("dniActual", dni);
			ArrayList<Prestamo> listaMisPrestamos = presNeg.obtenerPrestamosCliente(dni);
			request.setAttribute("listaMisPrestamos", listaMisPrestamos);
			RequestDispatcher rd = request.getRequestDispatcher("MisPrestamos.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("nroPre") != null) {
			ArrayList<Cuota> listaCuotas = cuoNeg.obtenerCuotas(Integer.valueOf(request.getParameter("nroPre")));
			request.setAttribute("nroPrestamo", request.getParameter("nroPre"));
			request.setAttribute("listaCuotas", listaCuotas);
			RequestDispatcher rd = request.getRequestDispatcher("CuotasPrestamo.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("lp") != null) {
			ArrayList<Prestamo> listaPrestamos = presNeg.obtenerTodos();
			request.setAttribute("listaPrestamos", listaPrestamos);
			RequestDispatcher rd = request.getRequestDispatcher("ListaPrestamos.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("dni") != null) {
			Cliente cli = new Cliente();
			cli = clNeg.obtenerUno(Integer.valueOf(request.getParameter("dni")));
			request.setAttribute("labelCliente", cli.getNombreCompleto());
			request.setAttribute("dniCliente", cli.getDni());
			ArrayList<Cuenta> listaCuentas = cuenNeg
					.obtenerCuentasCliente(Integer.valueOf(request.getParameter("dni")));
			request.setAttribute("listaCuentas", listaCuentas);
			RequestDispatcher rd = request.getRequestDispatcher("NuevoPrestamo.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("aut") != null) {
			boolean estado = presNeg.actualizar(1, Integer.valueOf(request.getParameter("aut")));
			if (estado) {
				RequestDispatcher rd = request.getRequestDispatcher("ServletPrestamos?lp=1");
				rd.forward(request, response);
			}

		} else if (request.getParameter("rech") != null) {
			boolean estado = presNeg.rechazar(2, Integer.valueOf(request.getParameter("rech")),
					String.valueOf(request.getParameter("motivoRechazo")));
			if (estado) {
				RequestDispatcher rd = request.getRequestDispatcher("ServletPrestamos?lp=1");
				rd.forward(request, response);
			}
		} else if (request.getParameter("cuo") != null) {

			int nroPrestamo = Integer.valueOf(request.getParameter("pres"));
			int nroCuota = Integer.valueOf(request.getParameter("cuo"));
			float Monto = Float.parseFloat(request.getParameter("txtMonto"));
			int nroCuenta = Integer.valueOf(request.getParameter("nroCuenta"));

			Movimiento mov = new Movimiento();
			mov.setDetalle("Pago prestamo N?" + nroPrestamo + ", Cuota N?" + nroCuota);
			mov.setImporte(Monto);

			Cuenta cuenta = new Cuenta(nroCuenta);
			mov.setCuenta(cuenta);

			TipoMovimiento tipoMov = new TipoMovimiento(3);
			mov.setTipoMovimiento(tipoMov);

			boolean estado = cuoNeg.pagarCuota(nroCuota, nroPrestamo, Monto);
			presNeg.descontarSaldoPrestamo(nroPrestamo,Monto);

			if (estado) {
				if (movNeg.agregar(mov)) {
					RequestDispatcher rd = request.getRequestDispatcher(
							"ServletPrestamos?nroPre=" + nroPrestamo);
					rd.forward(request, response);
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("btnAceptar") != null) {
			Prestamo NuevoPrestamo = new Prestamo();
			Cuota cuota = new Cuota();

			NuevoPrestamo.setImportePagar(Float.parseFloat(request.getParameter("txtMonto"))
					+ Float.parseFloat(request.getParameter("txtIntereses")));
			NuevoPrestamo.setImportePedido(Float.parseFloat(request.getParameter("txtMonto")));
			NuevoPrestamo.setPlazoMeses(Integer.valueOf(request.getParameter("cuotas")));
			NuevoPrestamo.setIntereses(Float.parseFloat(request.getParameter("txtIntereses")));
			NuevoPrestamo.setImporteCuota((Float.parseFloat(request.getParameter("txtMonto"))
					+ Float.parseFloat(request.getParameter("txtIntereses"))
							/ Integer.valueOf(request.getParameter("cuotas"))));
			Cliente c = new Cliente();
			c.setDni(Integer.valueOf(request.getParameter("DniValue")));

			Cuenta cu = new Cuenta();
			cu.setNumeroCuenta(Integer.valueOf(request.getParameter("ddlCuentas")));
			NuevoPrestamo.setCliente(c);
			NuevoPrestamo.setCuenta(cu);

			int idNuevoPrestamo = presNeg.insertar(NuevoPrestamo);

			cuota.setNumeroPrestamo(idNuevoPrestamo);
			cuota.setImporteCuota(NuevoPrestamo.getImporteCuota());
			cuota.setSaldoCuota(NuevoPrestamo.getImporteCuota());
			cuota.setNumeroCuota(Integer.valueOf(request.getParameter("cuotas")));

			if (idNuevoPrestamo > 0) {
				if (cuoNeg.insertarCuotas(cuota))
					response.sendRedirect("ServletPrestamos?mp=1");
			}
		}

	}

}