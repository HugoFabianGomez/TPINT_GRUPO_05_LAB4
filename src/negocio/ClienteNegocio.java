package negocio;

import java.util.ArrayList;

import entidades.Cliente;

public interface ClienteNegocio {
	public boolean agregar(Cliente cliente);
	public ArrayList<Cliente> obtenerTodos();
	public ArrayList<Cliente> obtenerTodos(int dni);
	public boolean modificar(Cliente cliente);
	public Cliente obtenerUno(int dni);
	public boolean borrar(int dni);
	

}
