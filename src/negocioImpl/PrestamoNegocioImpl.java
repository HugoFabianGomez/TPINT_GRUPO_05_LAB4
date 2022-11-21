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
	public boolean insertar(Prestamo prestamo) {
		return pDao.insertar(prestamo);
	}
}
