package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidades.Cuenta;
import entidades.Localidad;
import entidades.TipoMovimiento;
import negocio.CuentaNegocio;
import negocio.MovimientoNegocio;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import entidades.Movimiento;

@WebServlet("/ServletMovimientos")
public class ServletMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletMovimientos() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Transferencias
		
		if(request.getParameter("btnTranferencia")!=null)
		{
			//System.out.println("Entro Servlet Transferencia");
			MovimientoNegocio movNegocio = new MovimientoNegocioImpl();
			CuentaNegocio ctaNegocio = new CuentaNegocioImpl();
			int NroCbu = Integer.parseInt(request.getParameter("txtCbuDestino"));
			Cuenta ctaxCbu = ctaNegocio.obtenerUnoxCbu(NroCbu);
						
			int NroCta = ctaxCbu.getNumeroCuenta();
			System.out.println("NroCbu "+NroCbu+" NroCta "+NroCta);
			
			boolean Credito = false;
			boolean Debito = false;
			
			//Transferencia Credito
			Movimiento movC = new Movimiento();
			movC.setDetalle(request.getParameter("txtDetalle"));
			//System.out.println("Detalle= "+movC.getDetalle());
			movC.setImporte(Float.parseFloat(request.getParameter("textImporteTransferencia")));
			//System.out.println("Importe= "+movC.getImporte());
			movC.setCuenta(new Cuenta(NroCta));
			//System.out.println("Cuenta= "+movC.getCuenta().getNumeroCuenta());
			movC.setTipoMovimiento(new TipoMovimiento(6)); //Transferencia Acreditar = 6
			//System.out.println("TipoMovi= "+movC.getTipoMovimiento().getCodigo());
			
			Credito = movNegocio.agregar(movC);
			
			//Transferencia Debito
			Movimiento movD = new Movimiento();
			movD.setDetalle(request.getParameter("txtDetalle"));
			//System.out.println("Detalle= "+movD.getDetalle());
			float importe = Float.parseFloat(request.getParameter("textImporteTransferencia"));
			importe = (importe * -1);
			movD.setImporte(importe);
			//System.out.println("Importe= "+movD.getImporte());
			movD.setCuenta(new Cuenta(Integer.parseInt(request.getParameter("txtCuenta"))));
			//System.out.println("Cuenta= "+movD.getCuenta().getNumeroCuenta());
			movD.setTipoMovimiento(new TipoMovimiento(4));	//Transferencia Debitar = 4
			//System.out.println("TipoMovi= "+movD.getTipoMovimiento().getCodigo());
			Debito = movNegocio.agregar(movD);
			System.out.println("Credito "+Credito+" "+Debito);
			
			//REQUESTDISPATCHER
			request.setAttribute("filas", Credito);
			RequestDispatcher rd = request.getRequestDispatcher("/Inicio.jsp");   
	        rd.forward(request, response);
	        
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
