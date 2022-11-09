package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ProvinciaDao;
import entidades.Localidad;
import entidades.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao{
private Conexion cn;
	
	public ProvinciaDaoImpl(){
		
	}
	
	@Override
	public List<Provincia> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Provincia> list = new ArrayList<Provincia>();
		 try
		 {
			 ResultSet rs= cn.query("select codigo_provincia_PRO, descripcion_PRO from provincias;");
			 while(rs.next())
			 {				
				 Provincia pro = new Provincia();
				 pro.setCodigo(rs.getInt("provincias.codigo_provincia_PRO"));
				 pro.setDescripcion(rs.getString("provincias.descripcion_PRO"));
				 
				 list.add(pro);
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
