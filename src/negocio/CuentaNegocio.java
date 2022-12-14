package negocio;

import java.util.ArrayList;

import entidades.Cuenta;

public interface CuentaNegocio {
	public boolean insertar(Cuenta cuenta);
	public boolean modificar(Cuenta cuenta);
	public boolean eliminar(int numeroCuenta);
	public Cuenta obtenerUno(int numeroCuenta);
	public Cuenta obtenerUnoxCbu(int numeroCuenta);
	public ArrayList<Cuenta> obtenerxNumero(int numeroCuenta);
	public ArrayList<Cuenta> obtenerTodos();
	public ArrayList<Cuenta> obtenerTodos(int dni);
	public ArrayList<Cuenta> obtenerCuentasCliente(int dni);
	public int cantidadCuentas(int dni);
	boolean existeNumero(int numeroCuenta);
	boolean existeCbu(int cbu);
	boolean existeDniCuenta(int dni);
}
