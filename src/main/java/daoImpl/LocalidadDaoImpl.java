package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.LocalidadDao;
import daoImpl.Conexion;
import entidades.Localidad;
import entidades.Provincia;

public class LocalidadDaoImpl implements LocalidadDao{

	private Conexion cn;
	
	public LocalidadDaoImpl(){
		
	}
	
	@Override
	public List<Localidad> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Localidad> list = new ArrayList<Localidad>();
		 try
		 {
			 ResultSet rs= cn.query("select codigo_localidad_LOC, descripcion_LOC, codigo_provincia_PRO, descripcion_PRO from localidades inner join provincias on codigo_provincia_LOC = codigo_provincia_PRO;");
			 while(rs.next())
			 {
				 Localidad loc = new Localidad();
				 loc.setCodigo(rs.getInt("localidades.codigo_localidad_LOC"));
				 loc.setDescripcion(rs.getString("localidades.descripcion_LOC"));
				 
				 Provincia pro = new Provincia();
				 pro.setCodigo(rs.getInt("provincias.codigo_provincia_PRO"));
				 pro.setDescripcion(rs.getString("provincias.descripcion_PRO"));
	
				 loc.setProvincia(pro);
				 
				 list.add(loc);
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
