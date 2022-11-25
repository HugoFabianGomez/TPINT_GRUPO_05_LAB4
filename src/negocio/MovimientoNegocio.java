package negocio;

import java.util.ArrayList;


import entidades.Movimiento;

public interface MovimientoNegocio {
	public ArrayList<Movimiento> obtenerTodos();
	public ArrayList<Movimiento> obtenerTodosUsuario(String Usuario);
	public boolean agregar(Movimiento movi);
}
