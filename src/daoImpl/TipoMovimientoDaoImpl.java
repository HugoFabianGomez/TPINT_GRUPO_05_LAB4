package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.TipoMovimientoDao;
import entidades.TipoCuenta;
import entidades.TipoMovimiento;

public class TipoMovimientoDaoImpl implements TipoMovimientoDao{
	private Conexion cn;
	
	public TipoMovimientoDaoImpl(){
		
	}
	
	@Override
	public List<TipoMovimiento> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<TipoMovimiento> list = new ArrayList<TipoMovimiento>();
		 try
		 {
			 ResultSet rs= cn.query("select * from tiposmovimiento;");
			 while(rs.next())
			 {				
				 TipoMovimiento tmov = new TipoMovimiento();
				 tmov.setCodigo(rs.getInt("tiposmovimiento.codigo_tipo_cuenta_TCU"));
				 tmov.setDescripcion(rs.getString("tiposmovimiento.descripcion_TCU"));
				 
				 list.add(tmov);
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
