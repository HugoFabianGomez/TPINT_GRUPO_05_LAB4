package negocio;

import java.util.ArrayList;

import entidades.Cuota;

public interface CuotaNegocio {
	public boolean insertarCuotas(Cuota cuota);
	ArrayList<Cuota> obtenerCuotas(int nroPrestamo);
}
