package negocioImpl;

import java.util.ArrayList;

import dao.NacionalidadDao;
import daoImpl.NacionalidadDaoImpl;
import entidades.Nacionalidad;
import negocio.NacionalidadNegocio;

public class NacionalidadNegocioImpl implements NacionalidadNegocio {
	NacionalidadDao nacDao = new NacionalidadDaoImpl();

	@Override
	public ArrayList<Nacionalidad> obtenerTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Nacionalidad>) nacDao.obtenerTodos();
	}

}
