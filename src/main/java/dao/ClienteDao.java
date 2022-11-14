package dao;

import java.util.ArrayList;
import java.util.List;
import entidades.Cliente;

public interface ClienteDao {
	public ArrayList<Cliente> obtenerTodos();
	public ArrayList<Cliente> obtenerTodos(int dni);
	public Cliente obtenerUno(int dni);
	public boolean insertar(Cliente cliente);
	public boolean editar(Cliente cliente);
	public boolean borrar(int dni);
}
