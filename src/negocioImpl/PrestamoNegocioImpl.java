package negocioImpl;

import java.util.ArrayList;

import dao.PrestamoDao;
import daoImpl.PrestamoDaoImpl;
import entidades.Prestamo;
import negocio.PrestamoNegocio;

public class PrestamoNegocioImpl implements PrestamoNegocio {
	
	PrestamoDao pDao= new PrestamoDaoImpl();
	
	@Override
	public ArrayList<Prestamo> obtenerTodos() {
		return pDao.obtenerTodos();
	}
	
	@Override
	public ArrayList<Prestamo> obtenerPrestamosCliente(int dni) {
		return pDao.obtenerPrestamosCliente(dni);
	}
	
	@Override
	public int insertar(Prestamo prestamo) {
		return pDao.insertar(prestamo);
	}
	
	@Override
	public boolean actualizar(int estado, int nroprestamo) {		
		return pDao.actualizar(estado,nroprestamo);
	}
	
	@Override
	public boolean rechazar(int estado, int nroprestamo, String motivoRechazo) {		
		return pDao.rechazar(estado,nroprestamo,motivoRechazo);
	}
}
