package dao;

import java.util.ArrayList;

import entidades.Prestamo;

public interface PrestamoDao {

	int insertar(Prestamo prestamo);
	ArrayList<Prestamo> obtenerTodos();
	ArrayList<Prestamo> obtenerPrestamosCliente(int dni);

}