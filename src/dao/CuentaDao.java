package dao;

import java.util.ArrayList;

import entidades.Cuenta;

public interface CuentaDao {
	public boolean insertar(Cuenta cuenta);
	public boolean modificar(Cuenta cuenta);
	public boolean eliminar(int numeroCuenta);
	public Cuenta obtenerUno(int numeroCuenta);
	public Cuenta obtenerUnoxCbu(int cbu);
	public ArrayList<Cuenta> busquedaxDni(int dni);
	public ArrayList<Cuenta> busquedaxNumero(int numeroCuenta);
	public ArrayList<Cuenta> obtenerTodos();
	public ArrayList<Cuenta> obtenerCuentasCliente(int dni);
}
