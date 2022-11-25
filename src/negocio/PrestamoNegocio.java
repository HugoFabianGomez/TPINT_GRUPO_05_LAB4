package negocio;

import java.util.ArrayList;

import entidades.Prestamo;

public interface PrestamoNegocio {
	public ArrayList<Prestamo> obtenerTodos();
	public ArrayList<Prestamo> obtenerPrestamosCliente(int dni);
	public int insertar(Prestamo prestamo);
}
