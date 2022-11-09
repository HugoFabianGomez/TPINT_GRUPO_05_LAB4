package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.TipoCuentaDao;
import entidades.Provincia;
import entidades.TipoCuenta;

public class TipoCuentaDaoImpl implements TipoCuentaDao{
	private Conexion cn;
	
	public TipoCuentaDaoImpl(){
		
	}
	
	@Override
	public List<TipoCuenta> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<TipoCuenta> list = new ArrayList<TipoCuenta>();
		 try
		 {
			 ResultSet rs= cn.query("select * from tiposcuenta;");
			 while(rs.next())
			 {				
				 TipoCuenta tcu = new TipoCuenta();
				 tcu.setCodigo(rs.getInt("tiposcuenta.codigo_tipo_cuenta_TCU"));
				 tcu.setDescripcion(rs.getString("tiposcuenta.descripcion_TCU"));
				 
				 list.add(tcu);
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
