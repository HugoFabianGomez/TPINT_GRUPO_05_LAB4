package negocio;

import entidades.Usuario;

public interface UsuarioNegocio {

	public boolean agregar(Usuario usuario);
	public Usuario login(String usuario, String contrasenia);


}
