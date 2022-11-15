package negocioImpl;

import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;
import entidades.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio {
	UsuarioDao usuDao = new UsuarioDaoImpl();
	
	public Usuario usuario() {
		return null;
	}

	@Override
	public boolean agregar(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuDao.insertar(usuario);
	}

}
