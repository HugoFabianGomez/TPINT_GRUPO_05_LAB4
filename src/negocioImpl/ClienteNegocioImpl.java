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
	public boolean modificar(Cliente cliente) {
		// TODO Auto-generated method stub
		
		boolean estado = clienteDao.editar(cliente);  
		return estado;
	}

	@Override
	public ArrayList<Cliente> obtenerTodos(int dni) {
		// TODO Auto-generated method stub
		//System.out.println("Llegue al clienteNegocioImpl");
		return clienteDao.obtenerTodos(dni);
	}

	@Override
	public Cliente obtenerUno(int dni) {
		// TODO Auto-generated method stub
		return clienteDao.obtenerUno(dni);
	}

	@Override
	public boolean borrar(int dni) {
		// TODO Auto-generated method stub
		boolean estado = clienteDao.borrar(dni); 
		
		return estado;
	}

	@Override
	public Cliente obtenerUno(String usuario) {
		// TODO Auto-generated method stub
		return clienteDao.obtenerUno(usuario);
	}


}
