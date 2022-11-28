package negocio;

import java.util.ArrayList;

import entidades.Usuario;

public interface UsuarioNegocio {

	public boolean agregar(Usuario usuario);
	public Usuario login(String usuario, String contrasenia);
	public int obtenerDniUsuario(String user);
	public ArrayList<Usuario> obtenerTodos();
}
