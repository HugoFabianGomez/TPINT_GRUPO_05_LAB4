package negocioImpl;

import java.util.ArrayList;

import dao.GeneroDao;
import daoImpl.GeneroDaoImpl;
import entidades.Genero;
import negocio.GeneroNegocio;

public class GeneroNegocioImpl implements GeneroNegocio {
	
	GeneroDao GenDao = new GeneroDaoImpl();

	@Override
	public ArrayList<Genero> obtenerTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Genero>) GenDao.obtenerTodos();
	}

}
