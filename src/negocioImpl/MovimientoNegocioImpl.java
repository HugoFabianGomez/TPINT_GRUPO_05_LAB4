package negocioImpl;

import java.util.ArrayList;

import dao.MovimientoDao;
import daoImpl.ClienteDaoImpl;
import daoImpl.MovimientoDaoImpl;
import entidades.Movimiento;
import negocio.MovimientoNegocio;

public class MovimientoNegocioImpl implements MovimientoNegocio {
	MovimientoDao movimientoDao = new MovimientoDaoImpl();
	@Override
	public ArrayList<Movimiento> obtenerTodos() {
		// TODO Auto-generated method stub
		return movimientoDao.obtenerTodos();
	}
	@Override
	public boolean agregar(Movimiento movi) {
		// TODO Auto-generated method stub
		return movimientoDao.agregar(movi);
	}
	
	@Override
	public ArrayList<Movimiento> obtenerTodosUsuario(String Usuario) {
		// TODO Auto-generated method stub
		return movimientoDao.obtenerTodosUsuario(Usuario);
	}

}
