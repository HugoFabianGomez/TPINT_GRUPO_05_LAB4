package dao;

import java.util.ArrayList;

import entidades.Cuota;

public interface CuotaDao {
	public boolean insertar(Cuota cuota);
	ArrayList<Cuota> obtenerCuotasPrestamo(int nroPrestamo);
}