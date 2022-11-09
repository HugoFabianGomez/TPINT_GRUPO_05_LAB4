package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.GeneroDao;
import entidades.Genero;

public class GeneroDaoImpl implements GeneroDao{

	private Conexion cn;
	
	public GeneroDaoImpl(){
		
	}
	
	@Override
	public List<Genero> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Genero> list = new ArrayList<Genero>();
		 try
		 {
			 ResultSet rs= cn.query("select codigo_genero_GEN, descripcion_GEN from generos;");
			 while(rs.next())
			 {				
				 Genero gen = new Genero();
				 gen.setCodigo(rs.getInt("generos.codigo_genero_GEN"));
				 gen.setDescripcion(rs.getString("generos.descripcion_GEN"));
				 
				 list.add(gen);
			 }
			 
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
