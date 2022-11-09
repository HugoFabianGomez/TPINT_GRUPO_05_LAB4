package dao;

import java.util.List;
import entidades.Cliente;

public interface ClienteDao {
	public List<Cliente> obtenerTodos();
	public boolean insertar(Cliente cliente);
	public boolean editar(Cliente cliente);
	public boolean borrar(int dni);
}
