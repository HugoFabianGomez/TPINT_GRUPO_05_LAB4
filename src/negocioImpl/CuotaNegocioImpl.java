package negocioImpl;

import java.util.ArrayList;

import dao.CuotaDao;
import daoImpl.CuotaDaoImpl;
import entidades.Cuenta;
import entidades.Cuota;
import negocio.CuentaNegocio;
import negocio.CuotaNegocio;

public class CuotaNegocioImpl implements CuotaNegocio{
	CuotaDao cDao = new CuotaDaoImpl();
	
	@Override
	public boolean insertarCuotas(Cuota cuota) {
		return cDao.insertar(cuota);
	}
	
	@Override
	public ArrayList<Cuota> obtenerCuotas(int nroPrestamo) {
		return cDao.obtenerCuotasPrestamo(nroPrestamo);
	}
}
