package negocioImpl;

import java.util.ArrayList;

import dao.LocalidadDao;
import daoImpl.LocalidadDaoImpl;
import entidades.Localidad;
import negocio.LocalidadNegocio;

public class LocalidadNegocioImpl implements LocalidadNegocio {
	LocalidadDao locDao = new LocalidadDaoImpl();

	@Override
	public ArrayList<Localidad> obtenerLocalidad() {
		// TODO Auto-generated method stub
		return (ArrayList<Localidad>) locDao.obtenerTodos();
	}

}
