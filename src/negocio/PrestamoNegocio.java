package negocio;

import java.util.ArrayList;

import entidades.Prestamo;

public interface PrestamoNegocio {
	public ArrayList<Prestamo> obtenerTodos();
	public ArrayList<Prestamo> obtenerPrestamosCliente(int dni);
	public int insertar(Prestamo prestamo);
	public boolean actualizar(int estado, int nroprestamo);
	public boolean rechazar(int estado, int nroprestamo, String motivoRechazo);
	boolean descontarSaldoPrestamo(int nroPrestamo, float Monto);
}
