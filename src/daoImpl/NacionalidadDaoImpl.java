package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.NacionalidadDao;
import entidades.Nacionalidad;
import entidades.Provincia;

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
			 while(rs.next())
			 {				
				 Nacionalidad nac = new Nacionalidad();
				 nac.setCodigo(rs.getInt("nacionalidades.codigo_nacionalidad_NAC"));
				 nac.setAbreviatura(rs.getString("nacionalidades.abreviatura_NAC"));
				 nac.setDescripcion(rs.getString("nacionalidades.descripcion_NAC"));
				 
				 list.add(nac);
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
