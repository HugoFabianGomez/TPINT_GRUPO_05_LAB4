package negocio;

import java.util.ArrayList;

import entidades.Cuenta;

public interface CuentaNegocio {
	public boolean insertar(Cuenta cuenta);
	public boolean modificar(Cuenta cuenta);
	public ArrayList<Cuenta> obtenerTodos();
}
