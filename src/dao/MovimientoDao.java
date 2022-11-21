package dao;

import java.util.ArrayList;


import entidades.Movimiento;

public interface MovimientoDao {
	public ArrayList<Movimiento> obtenerTodos();
	public boolean agregar(Movimiento movi);
	
}
