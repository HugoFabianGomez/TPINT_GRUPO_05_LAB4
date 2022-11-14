package negocioImpl;

import entidades.Cliente;
import negocio.ClienteNegocio;

import java.util.ArrayList;

import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;

public class ClienteNegocioImpl implements ClienteNegocio{
	ClienteDao clienteDao = new ClienteDaoImpl();

	@Override
	public boolean agregar(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.insertar(cliente);
	}
	
	public ArrayList<Cliente> obtenerTodos(){
		return clienteDao.obtenerTodos();
		
	}

	@Override
	public int modificar(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;//clienteDao.editar(cliente);
	}

	@Override
	public ArrayList<Cliente> obtenerTodos(int dni) {
		// TODO Auto-generated method stub
		return clienteDao.obtenerTodos(dni);
	}

	@Override
	public Cliente obtenerUno(int dni) {
		// TODO Auto-generated method stub
		return clienteDao.obtenerUno(dni);
	}


}
