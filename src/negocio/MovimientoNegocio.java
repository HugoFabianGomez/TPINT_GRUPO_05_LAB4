package negocio;

import java.util.ArrayList;


import entidades.Movimiento;

public interface MovimientoNegocio {
	public ArrayList<Movimiento> obtenerTodos();
	public boolean agregar(Movimiento movi);
}
