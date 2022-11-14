package negocioImpl;

import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;
import entidades.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio {
	UsuarioDao usu = new UsuarioDaoImpl();
	
	public Usuario usuario() {
		return null;
	}

}
