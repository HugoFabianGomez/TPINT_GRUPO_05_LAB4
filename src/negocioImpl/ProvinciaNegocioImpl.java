package negocioImpl;

import java.util.ArrayList;

import dao.ProvinciaDao;
import daoImpl.ProvinciaDaoImpl;
import entidades.Provincia;
import negocio.ProvinciaNegocio;

public class ProvinciaNegocioImpl implements ProvinciaNegocio {
	ProvinciaDao provDao = new ProvinciaDaoImpl();

	@Override
	public ArrayList<Provincia> obtenerTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Provincia>) provDao.obtenerTodos();
	}

}
