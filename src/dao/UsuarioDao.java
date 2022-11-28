package dao;

import java.util.ArrayList;
import java.util.List;
import entidades.Usuario;

public interface UsuarioDao {
	public ArrayList<Usuario> obtenerTodos();
	public boolean insertar(Usuario usuario);
	public boolean editar(Usuario usuario);
	public boolean borrar(String nombreUsuario);
	public Usuario login(String usuario, String pass);
	public int obtenerDniUser(String user);
}
