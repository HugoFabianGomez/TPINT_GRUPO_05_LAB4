package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.NacionalidadDao;
import entidades.Nacionalidad;

public class NacionalidadDaoImpl implements NacionalidadDao {
	private Conexion cn;
	
	public NacionalidadDaoImpl(){
		
	}
	
	@Override
	public List<Nacionalidad> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Nacionalidad> list = new ArrayList<Nacionalidad>();
		 try
		 {
			 ResultSet rs = cn.query("select * from nacionalidades;");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return list;
	}
}
