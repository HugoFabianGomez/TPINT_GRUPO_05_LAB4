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

	@Override
	public Usuario login(String usuario, String contrasenia) {
		// TODO Auto-generated method stub
		return usuDao.login(usuario, contrasenia);
	}
	
	@Override
	public int obtenerDniUsuario(String user) {
		return usuDao.obtenerDniUser(user);
	}
}
