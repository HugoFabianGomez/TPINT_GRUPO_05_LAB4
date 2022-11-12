package main;

import java.util.ArrayList;

import dao.GeneroDao;
import daoImpl.GeneroDaoImpl;
import entidades.Genero;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*PacienteDao pacientesDao = new PacienteDao();
		ArrayList<Paciente> listapacientes = pacientesDao.obtenerPacientes();
		System.out.println("LLEGUE ACA 1");
		for(Paciente pass : listapacientes)
		{
			System.out.println(pass.toString());
		}*/
		
		GeneroDao generodao = new GeneroDaoImpl();
		ArrayList<Genero> listagenero = (ArrayList<Genero>) generodao.obtenerTodos();
		
		System.out.println("LLEGUE ACA 1");
		
		int tamanio = listagenero.size();
		System.out.println("El número de elementos es de "+tamanio);
		
		for(Genero gen : listagenero) {
			System.out.println(gen.toString());
		}
		
		
			
		

	}

}
