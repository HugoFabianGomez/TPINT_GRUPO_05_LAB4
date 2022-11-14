package negocioImpl;

import java.util.ArrayList;

import dao.CuentaDao;
import daoImpl.CuentaDaoImpl;
import entidades.Cuenta;
import negocio.CuentaNegocio;

public class CuentaNegocioImpl implements CuentaNegocio {
	CuentaDao cuDao= new CuentaDaoImpl();

	@Override
	public boolean insertar(Cuenta cuenta) {
		return cuDao.insertar(cuenta);
	}

	@Override
	public ArrayList<Cuenta> obtenerTodos() {
		return cuDao.obtenerTodos();
	} 
}
