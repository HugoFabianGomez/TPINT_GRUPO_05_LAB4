package negocioImpl;

import entidades.Cliente;
import negocio.ClienteNegocio;
import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;

public class ClienteNegocioImpl implements ClienteNegocio{
	ClienteDao clienteDao = new ClienteDaoImpl();

	@Override
	public boolean agregar(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.insertar(cliente);
	}

}
