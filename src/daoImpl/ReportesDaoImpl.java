package daoImpl;

import java.sql.ResultSet;

import dao.ReportesDao;

public class ReportesDaoImpl implements ReportesDao{
	private Conexion cn;

	@Override
	public int cantidadClientes() {
		cn = new Conexion();
		cn.Open();
		int cantidad = 0;
			 try
			 {
				 ResultSet rs= cn.query("select count(*) as cantidad from usuarios where codigo_tipo_usuario_US = 2;");
	
				 	 rs.next();
					 cantidad = rs.getInt("cantidad");
					 
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 finally
			 {
				 cn.close();
			 }
		 return cantidad;
	}

	@Override
	public float ingresosTotales() {
		
		return 0;
	}
}
