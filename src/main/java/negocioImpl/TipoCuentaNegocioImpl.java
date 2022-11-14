package negocioImpl;

import java.util.ArrayList;

import dao.TipoCuentaDao;
import daoImpl.TipoCuentaDaoImpl;
import entidades.TipoCuenta;
import negocio.TipoCuentaNegocio;

public class TipoCuentaNegocioImpl implements TipoCuentaNegocio {

	private TipoCuentaDao tcDao = new TipoCuentaDaoImpl();
	
	@Override
	public ArrayList<TipoCuenta> obtenerTodos() {
		return tcDao.obtenerTodos();
	}
	
}
