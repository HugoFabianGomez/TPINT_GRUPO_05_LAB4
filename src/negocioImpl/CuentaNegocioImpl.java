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

	@Override
	public boolean modificar(Cuenta cuenta) {		
		return cuDao.modificar(cuenta);
	}

	@Override
	public Cuenta obtenerUno(int numeroCuenta) {		
		return cuDao.obtenerUno(numeroCuenta);
	}

	@Override
	public boolean eliminar(int numeroCuenta) {
		return cuDao.eliminar(numeroCuenta);
	}

	@Override
	public ArrayList<Cuenta> obtenerxNumero(int numeroCuenta) {
		return cuDao.busquedaxNumero(numeroCuenta);
	}

}
