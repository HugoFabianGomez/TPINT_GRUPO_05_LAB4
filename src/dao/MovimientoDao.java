package dao;

import java.util.ArrayList;


import entidades.Movimiento;

public interface MovimientoDao {
	public ArrayList<Movimiento> obtenerTodos();
	public ArrayList<Movimiento> obtenerTodosUsuario(String Usuario);
	public boolean agregar(Movimiento movi);
}
