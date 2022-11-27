package dao;

import java.util.ArrayList;

import entidades.Cuota;

public interface CuotaDao {
	public boolean insertar(Cuota cuota);
	ArrayList<Cuota> obtenerCuotasPrestamo(int nroPrestamo);
	public boolean pagarCuota(int nroCuota, int nroPrestamo);
}