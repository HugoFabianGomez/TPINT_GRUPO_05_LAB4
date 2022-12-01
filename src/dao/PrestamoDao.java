package dao;

import java.util.ArrayList;

import entidades.Prestamo;

public interface PrestamoDao {

	int insertar(Prestamo prestamo);
	ArrayList<Prestamo> obtenerTodos();
	ArrayList<Prestamo> obtenerPrestamosCliente(int dni);
	boolean actualizar(int estado, int nroPrestamo);
	boolean rechazar(int estado, int nroPrestamo, String motivoRechazo);
	boolean descontarSaldoPrestamo(int nroPrestamo, float Monto);
}